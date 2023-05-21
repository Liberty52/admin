package com.liberty52.admin.global.adapter.feign.error;

import com.liberty52.admin.global.exception.external.internalservererror.InternalServerErrorException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());

        if (status.is4xxClientError()) {
            log.error("Feign Client 4xx Error - status: {}, response: {}", status.value(), response.body());

            return switch (status) {
                case BAD_REQUEST -> new FeignBadRequestException(deserializeResponseMessage(response));
                case UNAUTHORIZED -> new FeignUnauthorizedException();
                case FORBIDDEN -> new FeignForbiddenException(deserializeResponseMessage(response));
                case NOT_FOUND -> new FeignNotFoundException(deserializeResponseMessage(response));
                default -> new Feign4xxException(deserializeResponseMessage(response));
            };

        } else if (status.is5xxServerError()) {
            log.error("Feign Client 5xx Error - status: {}, response message: {}", status.value(), response.body());
            return new Feign5xxException(deserializeResponseMessage(response));
        }

        return new FeignClientException(deserializeResponseMessage(response));
    }

    private String deserializeResponseMessage(Response response) {
        try {
            return new String(response.body().asInputStream().readAllBytes());
        } catch (Exception e) {
            log.error("Feign Client Error - deserialize response.\nResponse: {}", response.body());
            throw new InternalServerErrorException("내부 시스템 간의 통신에서 오류가 발생하였습니다.");
        }
    }

}

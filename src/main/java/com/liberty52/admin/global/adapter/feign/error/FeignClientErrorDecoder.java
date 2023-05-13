package com.liberty52.admin.global.adapter.feign.error;

import com.liberty52.admin.global.exception.external.internalservererror.InternalServerErrorException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());
        String responseMessage = deserializeResponseMessage(response);

        if (status.is4xxClientError()) {
            log.error("Feign Client 4xx Error - status: {}, response: {}", status.value(), responseMessage);

            return switch (status) {
                case UNAUTHORIZED -> new FeignUnauthorizedException(responseMessage);
                case FORBIDDEN -> new FeignForbiddenException(responseMessage);
                case BAD_REQUEST -> new FeignBadRequestException(responseMessage);
                default -> new Feign4xxException(responseMessage);
            };

        } else if (status.is5xxServerError()) {
            log.error("Feign Client 5xx Error - status: {}, response message: {}", status.value(), responseMessage);
            return new Feign5xxException(responseMessage);
        }

        return new FeignClientException(responseMessage);
    }

    private String deserializeResponseMessage(Response response) {
        try {
            return new String(response.body().asInputStream().readAllBytes());
        } catch (IOException e) {
            log.error("Feign Client Error - deserialize response");
            throw new InternalServerErrorException("내부 시스템 사이에 오류가 발생하였습니다.");
        }
    }

}

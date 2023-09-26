package com.liberty52.admin.global.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignImageConfig {

	private final ObjectFactory<HttpMessageConverters> messageConverters;

	public FeignImageConfig(ObjectFactory<HttpMessageConverters> messageConverters) {
		this.messageConverters = messageConverters;
	}

	@Bean
	public Encoder feignFormEncoder() {
		return new SpringFormEncoder(new SpringEncoder(messageConverters));
	}
}

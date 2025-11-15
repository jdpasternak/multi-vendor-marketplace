package com.jakepasternak.multi_vendor_marketplace.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.resourceserver.jwt")
public class JwtConfig {

    private String secretKey;

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        return NimbusReactiveJwtDecoder.withSecretKey(key).build();
    }
}
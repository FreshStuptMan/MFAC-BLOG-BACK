package com.mfac.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTProperties {
    private String secretKey;
    private Long ttl;
    private String tokenName;
    private String userId;
}

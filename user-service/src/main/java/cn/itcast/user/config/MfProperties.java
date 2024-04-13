package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "mf")
public class MfProperties {
    private String name;
    private String like;
    private String loverPhone;
    private String lovePeople;
}

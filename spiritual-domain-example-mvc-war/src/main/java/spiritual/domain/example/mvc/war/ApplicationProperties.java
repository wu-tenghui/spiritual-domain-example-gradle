/*
 *
 */
package spiritual.domain.example.mvc.war;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 *
 */
@ConfigurationProperties(prefix = "spiritual-domain.example-mvc-war", ignoreUnknownFields = false)
@RefreshScope
public class ApplicationProperties {

    /**
     *
     */
    private Boolean swaggerEnable = false;

    /**
     *
     */
    private String message = "";

    public Boolean getSwaggerEnable() {
        return swaggerEnable;
    }

    public void setSwaggerEnable(Boolean swaggerEnable) {
        this.swaggerEnable = swaggerEnable;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

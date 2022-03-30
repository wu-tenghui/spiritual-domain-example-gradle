/*
 *
 */
package spiritual.domain.example.webflux;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 *
 */
@ConfigurationProperties(prefix = "spiritual-domain.example-webflux", ignoreUnknownFields = false)
@RefreshScope
public class ApplicationProperties {

    /**
     *
     */
    private String message = "";

    /**
     *
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     */
    public void setMessage(String message) {
        this.message = message;
    }

}

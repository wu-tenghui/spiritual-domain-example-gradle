/*
 *
 */
package spiritual.domain.example.webflux;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 *
 */
@Configuration(value = "spiritual-domain-example-webflux")
@EnableConfigurationProperties({ApplicationProperties.class})
public class ApplicationConfiguration {

    /**
     *
     */
    @Value("${server.servlet.context-path:${spring.mvc.servlet.path:${spring.webflux.base-path:/}}}")
    private String server;

    /**
     *
     */
    @Bean("spiritual-domain-example-webflux-OpenAPI")
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("spiritual-domain-example-webflux")
                                .description("spiritual-domain-example-webflux documents")
                                .version("V1.0")
                )
                .servers(
                        Collections.singletonList(
                                new Server()
                                        .description("spiritual-domain-example-webflux")
                                        .url(server)
                        )
                );
    }

    /**
     *
     */
    @Bean("spiritual-domain-example-webflux-OperationCustomizer")
    public OperationCustomizer operationCustomizer() {
        return (operation, handlerMethod) -> {
            operation.addParametersItem(
                    new Parameter()
                            .name("Authorization")
                            .description("Authorization访问令牌")
                            .schema(new StringSchema())
                            .in(ParameterIn.HEADER.name())
                            .required(true)
                            .example("bearer God_access_token")
            );
            return operation;
        };
    }

    /**
     *
     */
    @Bean("spiritual-domain-example-webflux-GroupedOpenApi")
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("spiritual-domain-example-webflux")
                .addOperationCustomizer(operationCustomizer())
                .packagesToScan("spiritual.domain.example.webflux")
                .build();
    }

}

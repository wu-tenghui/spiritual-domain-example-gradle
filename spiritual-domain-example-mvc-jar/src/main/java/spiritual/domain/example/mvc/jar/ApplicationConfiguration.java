/*
 *
 */
package spiritual.domain.example.mvc.jar;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Configuration(value = "spiritual-domain-example-mvc-jar")
@EnableConfigurationProperties({ApplicationProperties.class})
@EnableSwagger2
public class ApplicationConfiguration {

    /**
     *
     */
    @Bean(name = "spiritual-domain-example-mvc-jar-docket")
    public Docket buildDocket(final ApplicationProperties applicationProperties) {

        List<Parameter> operationParameters = new ArrayList<>();

        operationParameters.add(new ParameterBuilder()
                .name("Authorization")
                .description("Authorization访问令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .defaultValue("bearer God_access_token")
                .build()
        );

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("spiritual-domain-example-mvc-jar")
                .description("spiritual-domain-example-mvc-jar documents")
                .version("V1.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("spiritual-domain-example-mvc-jar")
                .globalOperationParameters(operationParameters)
                .apiInfo(apiInfo)
                .enable(applicationProperties.getSwaggerEnable())
                .select()
                .apis(RequestHandlerSelectors.basePackage("spiritual.domain.example.mvc.jar"))
                .paths(PathSelectors.any())
                .build();
    }

}

package br.coop.integrada.ApiFrotas.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("FROTAS")
                        .description("Frotas Micro-Services Integrada 2022")
                        .version("2.0")
                        .contact(new Contact()
                                .name("INTEGRADA AGROINDUSTRIAL")
                                .url("https://www.integrada.coop.br/")
                                .email("reginaldo.rocha@integrada.coop.br"))
                                .license(new License().name("Apache License Version 2.0")
                                		.url("https://www.apache.org/licenses/LICENSE-2.0.txt"))
                );
    }
}

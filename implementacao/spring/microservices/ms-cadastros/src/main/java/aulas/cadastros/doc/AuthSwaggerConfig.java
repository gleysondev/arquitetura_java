package aulas.cadastros.doc;

import org.springframework.context.annotation.Configuration;

import aulas.doc.SwaggerConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AuthSwaggerConfig extends SwaggerConfig {
	public AuthSwaggerConfig() {
		super("aulas.cadastros.resource");
	}

}


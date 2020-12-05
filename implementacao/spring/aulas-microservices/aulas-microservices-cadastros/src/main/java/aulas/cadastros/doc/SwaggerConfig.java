package aulas.cadastros.doc;

import org.springframework.context.annotation.Configuration;

import aulas.doc.BaseSwaggerConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
	public SwaggerConfig() {
		super("aulas.cadastros.resource");
	}

}

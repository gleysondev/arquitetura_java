package aulas.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;



//@Configuration
public class PostoRouter {
	@Bean
	public RouterFunction<ServerResponse> route(PostoHandler handler) {
		return RouterFunctions
				
				.route(GET("/posto").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/posto/{Id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/posto").and(accept(MediaType.APPLICATION_JSON)), handler::save);
	}

}

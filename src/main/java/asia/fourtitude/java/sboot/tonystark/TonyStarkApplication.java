package asia.fourtitude.java.sboot.tonystark;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product API", version = "2.0", description = "Product Rest"))
public class TonyStarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TonyStarkApplication.class, args);
	}

}

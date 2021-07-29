package apicontroledeservicoprestado;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApiControleDeServicoPrestadoApplication {
	
	//@Autowired
	//@Qualifier("applicationName")
	@Value("${application.name}")
	private String applicatioName;
	
	
	@GetMapping("/")
	public String helloWorld() {
		return  applicatioName;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiControleDeServicoPrestadoApplication.class, args);
	}

}

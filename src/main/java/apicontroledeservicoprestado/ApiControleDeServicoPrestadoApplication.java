package apicontroledeservicoprestado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiControleDeServicoPrestadoApplication {

	/*@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository) {

		return args -> {

			Cliente cliente = new Cliente();

			cliente.setNome("José Junior");
			cliente.setCpf("03581874585");
			cliente.setDataCadastro(LocalDate.now());

			repository.save(cliente);

		};

	} */

	public static void main(String[] args) {
		SpringApplication.run(ApiControleDeServicoPrestadoApplication.class, args);
	}

}

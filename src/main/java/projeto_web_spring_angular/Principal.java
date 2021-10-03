package projeto_web_spring_angular;	

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Principal {
	public static void main(String[] args) {  
        
		SpringApplication.run(Principal.class, args);
		
	}
	
	/*
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository) {
		return args -> {
			Cliente cliente = new Cliente("00000000000", "Fulano");
			repository.save(cliente);
		};
	}
	*/
}

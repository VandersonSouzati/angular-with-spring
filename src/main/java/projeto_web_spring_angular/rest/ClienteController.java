package projeto_web_spring_angular.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projeto_web_spring_angular.model.entity.Cliente;
import projeto_web_spring_angular.model.repository.ClienteRepository;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody @Valid Cliente cliente) {
		return repository.save(cliente);
	}

	@GetMapping("{id}")
	public Cliente buscaPorId(@PathVariable Integer id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {

		repository.findById(id)
		  .map(cliente -> {
			  repository.delete(cliente);
			  return Void.TYPE;
		  }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
	
	@PutMapping("{id}")
	public void atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
	    repository.findById(id)
	              .map(cliente ->{
	            	  cliente.setCpf(clienteAtualizado.getCpf());
	            	  cliente.setNome(clienteAtualizado.getNome());
	            	  
	            	  return repository.save(cliente);
	              })
	              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
	
}

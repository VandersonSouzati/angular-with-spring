package projeto_web_spring_angular.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import projeto_web_spring_angular.rest.error.ApiErros;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiErros handleValidationErros(MethodArgumentNotValidException ex) {
		BindingResult bindResult = ex.getBindingResult();
        
		List<String> errors = bindResult.getAllErrors()
               .stream()
               .map( objectError -> objectError.getDefaultMessage() )
               .collect(Collectors.toList());
		
		return new ApiErros(errors);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handValidationErros(ResponseStatusException ex) {
		String error = ex.getMessage();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErros apiErros = new ApiErros(error);
		
		return new ResponseEntity(apiErros, codigoStatus);
	}
}

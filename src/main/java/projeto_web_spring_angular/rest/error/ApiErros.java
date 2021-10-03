package projeto_web_spring_angular.rest.error;

import java.util.Arrays;
import java.util.List;

public class ApiErros {

	private List<String> erros;
	
	public ApiErros(List<String> listaErros) {
		this.erros = listaErros;
	}
	
	public ApiErros(String menssagemErro) {
		this.erros = Arrays.asList(menssagemErro);
	}
	
	public List<String> getMensagensErro(){
		return this.erros;
	}
}

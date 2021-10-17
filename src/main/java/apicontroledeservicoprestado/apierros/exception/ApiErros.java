package apicontroledeservicoprestado.apierros.exception;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiErros {

	private List<String> erros;

	public ApiErros(List<String> erros) {
		this.erros = erros;
	}
	
	public ApiErros(String message) {
		
		this.erros = Arrays.asList(message);
	}
}

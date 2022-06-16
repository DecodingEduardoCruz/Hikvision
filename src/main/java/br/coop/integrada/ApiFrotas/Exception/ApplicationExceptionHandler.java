package br.coop.integrada.ApiFrotas.Exception;

import org.apache.http.conn.HttpHostConnectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity handleException(NullPointerException e) {
		if(e.getMessage().isEmpty()) {
			DefaultExceptions exception = new DefaultExceptions(HttpStatus.NOT_FOUND.value(), "Não existem resultados para essa busca!");
			return new ResponseEntity(exception, HttpStatus.NOT_FOUND);	
		}else {
			DefaultExceptions exception = new DefaultExceptions(HttpStatus.NOT_FOUND.value(), "Atenção! " + e.getMessage());
			return new ResponseEntity(exception, HttpStatus.NOT_FOUND);	
		}
	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception e) {
		DefaultExceptions exception = new DefaultExceptions(HttpStatus.BAD_GATEWAY.value(), "ATENÇÃO! Não foi possivel processar sua requisição!");
		return new ResponseEntity(exception, HttpStatus.BAD_GATEWAY);		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(HttpHostConnectException.class)
	public ResponseEntity handleException(HttpHostConnectException e) {
		DefaultExceptions exception = new DefaultExceptions(HttpStatus.BAD_GATEWAY.value(), "Camera off-line!");
		return new ResponseEntity(exception, HttpStatus.NOT_FOUND);		
	}
}

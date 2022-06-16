package br.coop.integrada.ApiFrotas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.coop.integrada.ApiFrotas.Modelo.EntradaSaidaVeiculo;
import br.coop.integrada.ApiFrotas.Services.EntradaSaidaVeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("camera/")
@Tag(name = "Portaria", description = "Retorna eventos da camera.")
public class Veiculos {
	
	@Autowired
	private EntradaSaidaVeiculoService service;
	
	@Operation(summary = "Todos os registros", description = "Retorna todos os registros da portaria.")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Não autorizado!",  content = { @Content(examples = { @ExampleObject(value = "Permissão negada!") }) }),
			@ApiResponse(responseCode = "404", description = "Não encontrado!",  content = { @Content(examples = { @ExampleObject(value = "Não foi possivel encontrar sua requisição!") }) }),
			@ApiResponse(responseCode = "500", description = "Tipo de retorno invalido!",  content = { @Content(examples = { @ExampleObject(value = "Houve uma falha ao retornar sua busca!") }) })			
			
	})
	
	@GetMapping("/todos")
	public List<EntradaSaidaVeiculo> todos(){
		return service.buscarTodos();
	}
	
	@Operation(summary = "Registros de um veiculo", description = "Retorna todos os registros de um veículo.")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
			@ApiResponse(responseCode = "400", description = "Não autorizado!",  content = { @Content(examples = { @ExampleObject(value = "Permissão negada!") }) }),
			@ApiResponse(responseCode = "404", description = "Não encontrado!",  content = { @Content(examples = { @ExampleObject(value = "Não foi possivel encontrar sua requisição!") }) }),
			@ApiResponse(responseCode = "500", description = "Tipo de retorno invalido!",  content = { @Content(examples = { @ExampleObject(value = "Houve uma falha ao retornar sua busca!") }) })			
			
	})
	
	@GetMapping("/placa/{placa}")
	public List<EntradaSaidaVeiculo> placa(@PathVariable( name="placa")String placa){
		return service.buscarPlaca(placa);
	}
}

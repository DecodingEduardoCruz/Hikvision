package br.coop.integrada.ApiFrotas.ApiClient;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import br.coop.integrada.ApiFrotas.Services.EntradaSaidaVeiculoService;

@Component
@EnableScheduling
public class EventStart {
	private final long EVENTO = 5 * 60 * 1000; //Intervalo de consulta

	@Autowired
	private EntradaSaidaVeiculoService entradaSaidaVeiculoService;

	@Scheduled(fixedDelay = EVENTO)
	public void verificaPorHora() {
		entradaSaidaVeiculoService.buscarDados();
	}
}

package br.coop.integrada.ApiFrotas.Services;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Service;
import br.coop.integrada.ApiFrotas.ApiClient.EventoXml;
import br.coop.integrada.ApiFrotas.ApiClient.RequesPush;
import br.coop.integrada.ApiFrotas.Modelo.EntradaSaidaVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import br.coop.integrada.ApiFrotas.Repository.EntradaSaidaVeiculoRepository;

@Service
public class EntradaSaidaVeiculoService {

	@Autowired
	private RequesPush requesPush;

	@Autowired
	private EntradaSaidaVeiculoRepository entradaSaidaVeiculoRepository;

	public void buscarDados() {
		try {
			List<EventoXml> lista = requesPush.getPlates();

			for (EventoXml evento : lista) {
				EntradaSaidaVeiculo veiculo = new EntradaSaidaVeiculo();
				veiculo.setPlaca(evento.getPlateNumber());				
				veiculo.setDataHora(DateFormat(evento.getCaptureTime()));
				veiculo.setChannelID("1");				
				veiculo.setTipoEvento("Entrada/Saida");
				veiculo.setNivelConfidence("unrestricted");
				veiculo.setNumeroIP("192.168.1.10"); //Ip camera
				
				if (evento.getDirection().equals("forward")) {
					veiculo.setFaixa("Esquerda"); 	
					veiculo.setDirecao("Entrada");
					
				} else if (evento.getDirection().equals("reverse")) { 
					veiculo.setFaixa("Direita");
					veiculo.setDirecao("Saida");
					
				} else { 
					veiculo.setFaixa("Indefinido");
					veiculo.setDirecao("Indefinido");
				}
		
				if(entradaSaidaVeiculoRepository.findByDataHora(DateFormat(evento.getCaptureTime())) == null) {
					entradaSaidaVeiculoRepository.save(veiculo);					
				}				
			}
		} catch (Exception e) {
			return;
		}
	}
	
	//Converte data e hora 
	public static Date DateFormat(String dados) throws ParseException{
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMdd'T'HHmmss-300", new Locale(getCountry())).parse(dados);
		}catch(Exception e) {
			System.out.println("...");
		}	
        return date;
    }

	//Verifica se o registro ja existe
	public List<EntradaSaidaVeiculo> buscarTodos() {
		return entradaSaidaVeiculoRepository.findByOrderByIdDesc();
	}

	//busca uma placa
	public List<EntradaSaidaVeiculo> buscarPlaca(String placa) {
		return entradaSaidaVeiculoRepository.findByPlaca(placa);
	}

	//busca o local time
	public static String getCountry() {
		Locale locale = Locale.getDefault();
		String country = String.valueOf(locale.getCountry());
		return country.toLowerCase();
	}
}

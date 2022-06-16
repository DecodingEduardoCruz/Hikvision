package br.coop.integrada.ApiFrotas.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.coop.integrada.ApiFrotas.Modelo.EntradaSaidaVeiculo;

public interface EntradaSaidaVeiculoRepository extends JpaRepository<EntradaSaidaVeiculo, Long>{
	public List<EntradaSaidaVeiculo> findByOrderByIdDesc();
	public List<EntradaSaidaVeiculo> findByDataHora(Date data);
	public List<EntradaSaidaVeiculo> findByPlaca(String placa);
	

}

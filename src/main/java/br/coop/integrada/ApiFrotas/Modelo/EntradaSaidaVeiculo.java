package br.coop.integrada.ApiFrotas.Modelo;

import java.util.Date;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@SuppressWarnings("serial")
@Table(name = "Portaria", schema = "banco")
public class EntradaSaidaVeiculo implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "placa", nullable = false)
    private String placa;
    
    @Column(name = "channel_id", nullable = false)
    private String channelID;

    @Column(name = "data_hora", unique = true)
    private Date dataHora;     
    
    @Column(name = "tipo_evento", nullable = false)
    private String tipoEvento;
    
    @Column(name = "faixa", nullable = false)
    private String faixa;
    
    @Column(name = "direcao", nullable = false)
    private String direcao;
    
    @Column(name = "nivel_confidence", nullable = false)
    private String nivelConfidence;
    
    @Column(name = "numero_ip", nullable = false)
    private String numeroIP;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}	

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getFaixa() {
		return faixa;
	}

	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getNivelConfidence() {
		return nivelConfidence;
	}

	public void setNivelConfidence(String nivelConfidence) {
		this.nivelConfidence = nivelConfidence;
	}

	public String getNumeroIP() {
		return numeroIP;
	}

	public void setNumeroIP(String numeroIP) {
		this.numeroIP = numeroIP;
	}   
}

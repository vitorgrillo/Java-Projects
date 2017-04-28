package com.VitorGrillo.entity;
import java.util.Date;

public class Consulta {
	private int id;
	private Date data;
	private	String inicio;
	private String fim;
	private int	IdDisponibilidade;
	private String observacoes;
	private String pedidosexame;
	private String prescricoes;
	private String recomendacoes;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public int getIdDisponibilidade() {
		return IdDisponibilidade;
	}

	public void setIdDisponibilidade(int idDisponibilidade) {
		IdDisponibilidade = idDisponibilidade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getPedidosexame() {
		return pedidosexame;
	}

	public void setPedidosexame(String pedidosexame) {
		this.pedidosexame = pedidosexame;
	}

	public String getPrescricoes() {
		return prescricoes;
	}

	public void setPrescricoes(String prescricoes) {
		this.prescricoes = prescricoes;
	}

	public String getRecomendacoes() {
		return recomendacoes;
	}

	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}

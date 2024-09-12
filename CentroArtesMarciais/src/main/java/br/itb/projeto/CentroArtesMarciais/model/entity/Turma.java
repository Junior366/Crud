package br.itb.projeto.CentroArtesMarciais.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Turma")
public class Turma {
	@Id
	@GeneratedValue
	  (strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private LocalDate ano;
	private String modalidade;
	private String statusTurma;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getAno() {
		return ano;
	}
	public void setAno(LocalDate ano) {
		this.ano = ano;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getStatusTurma() {
		return statusTurma;
	}
	public void setStatusTurma(String statusTurma) {
		this.statusTurma = statusTurma;
	}
	
}

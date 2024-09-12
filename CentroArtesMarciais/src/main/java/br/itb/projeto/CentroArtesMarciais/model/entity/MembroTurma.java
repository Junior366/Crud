package br.itb.projeto.CentroArtesMarciais.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MembroTurma")
public class MembroTurma {
	@Id
	@GeneratedValue
	  (strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String statusMembroTurma;
	
	@ManyToOne
	@JoinColumn(name = "Membro_id")
	private Membro membro;
	@ManyToOne
	@JoinColumn(name = "Turma_id")
	private Turma turma;
	public long getId() {
		return id;
		
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getStatusMembroTurma() {
		return statusMembroTurma;
	}
	public void setStatusMembroTurma(String statusMembroTurma) {
		this.statusMembroTurma = statusMembroTurma;
	}
	public Membro getMembro() {
		return membro;
	}
	public void setMembro(Membro membro) {
		this.membro = membro;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public void setId(long id) {
		this.id = id;
	}

	
}

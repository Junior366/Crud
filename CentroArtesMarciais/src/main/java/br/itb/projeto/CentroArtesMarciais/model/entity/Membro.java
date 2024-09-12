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
@Table(name = "Membro")
public class Membro { 
	@Id
	@GeneratedValue
	  (strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cpf;
	private LocalDate dataNasc;
	private Long telefone;
	private String statusMembro;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getStatusMembro() {
		return statusMembro;
	}

	public void setStatusMembro(String statusMembro) {
		this.statusMembro = statusMembro;
	}

	}
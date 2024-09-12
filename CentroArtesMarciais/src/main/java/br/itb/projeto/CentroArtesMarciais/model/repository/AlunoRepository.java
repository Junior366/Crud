package br.itb.projeto.CentroArtesMarciais.model.repository;

import java.util.List;

import br.itb.projeto.CentroArtesMarciais.model.entity.Aluno;

public interface AlunoRepository {

	Aluno find();
	
	List<Aluno> findAll();
	
	Aluno findByRm(long rm);
	
}










package br.itb.projeto.CentroArtesMarciais.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.CentroArtesMarciais.model.entity.Turma;
import br.itb.projeto.CentroArtesMarciais.service.TurmaService;

@RestController
@RequestMapping("/Turma/")
public class TurmaController {

	private TurmaService turmaService;

	public TurmaController(TurmaService turmaService) {
		super();
		this.turmaService = turmaService;
	}
	
	@GetMapping("findAll")public ResponseEntity<List<Turma>> findAll() {
		List<Turma> turmas = turmaService.findAll();

		return new ResponseEntity<List<Turma>>(turmas, HttpStatus.OK);
		
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Turma> findById(@PathVariable long id) {
		Turma turma = turmaService.findById(id);

		return new ResponseEntity<Turma>(turma, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<Turma> create(@RequestBody Turma turma) {

		Turma _turma = turmaService.create(turma);

		return new ResponseEntity<Turma>(_turma, HttpStatus.OK);
	}
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Turma> inativar(@PathVariable long id) {

		Turma turma = turmaService.inativar(id);

		return new ResponseEntity<Turma>(turma, HttpStatus.OK);
	}

	@PutMapping("reativar/{id}")
	public ResponseEntity<Turma> reativar(@PathVariable long id) {

		Turma turma = turmaService.reativar(id);

		return new ResponseEntity<Turma>(turma, HttpStatus.OK);
	}
}


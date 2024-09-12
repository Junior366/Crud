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

import br.itb.projeto.CentroArtesMarciais.model.entity.MembroTurma;
import br.itb.projeto.CentroArtesMarciais.service.MembroTurmaService;

@RestController
@RequestMapping("/MembroTurma/")
public class MembroTurmaController {

	private MembroTurmaService membroTurmaService;

	public MembroTurmaController(MembroTurmaService membroTurmaService) {
		super();
		this.membroTurmaService = membroTurmaService;
	}
	@GetMapping("findAll")
	public ResponseEntity<List<MembroTurma>> findAll() {
		List<MembroTurma> membroTurmas = membroTurmaService.findAll();

		return new ResponseEntity<List<MembroTurma>>(membroTurmas, HttpStatus.OK);
 }
	@GetMapping("findById/{id}")
	public ResponseEntity<MembroTurma> findById(@PathVariable long id) {
		MembroTurma membroTurma = membroTurmaService.findById(id);

		return new ResponseEntity<MembroTurma>(membroTurma, HttpStatus.OK);

	}


	@PostMapping("create")
	public ResponseEntity<MembroTurma> create(@RequestBody MembroTurma membroTurma) {

		MembroTurma _membroTurma = membroTurmaService.create(membroTurma);

		return new ResponseEntity<MembroTurma>(_membroTurma, HttpStatus.OK);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<MembroTurma> inativar(@PathVariable long id) {

		MembroTurma membroTurma = membroTurmaService.inativar(id);

		return new ResponseEntity<MembroTurma>(membroTurma, HttpStatus.OK);
	}

	@PutMapping("reativar/{id}")
	public ResponseEntity<MembroTurma> reativar(@PathVariable long id) {

		MembroTurma membroTurma = membroTurmaService.reativar(id);

		return new ResponseEntity<MembroTurma>(membroTurma, HttpStatus.OK);
		}
	}
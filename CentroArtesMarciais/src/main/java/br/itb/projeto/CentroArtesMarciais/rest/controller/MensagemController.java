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

import br.itb.projeto.CentroArtesMarciais.model.entity.Mensagem;
import br.itb.projeto.CentroArtesMarciais.service.MensagemService;

@RestController
@RequestMapping("/mensagem/")
public class MensagemController {

	private MensagemService mensagemService;

	public MensagemController(MensagemService mensagemService) {
		this.mensagemService = mensagemService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Mensagem>> findAll() {
		List<Mensagem> mensagens = mensagemService.findAll();

		return new ResponseEntity<List<Mensagem>>(
								mensagens, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Mensagem> findById(
			@PathVariable long id){
		Mensagem mensagem = mensagemService.findById(id);
		
		return new ResponseEntity<Mensagem>
						(mensagem, HttpStatus.OK);
		
	}
	
	@PostMapping("create")
	public ResponseEntity<Mensagem> create (
			@RequestBody Mensagem mensagem){
		
		Mensagem _mensagem = 
				mensagemService.create(mensagem);
		
		return new ResponseEntity<Mensagem>
				      (_mensagem, HttpStatus.OK);	
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Mensagem> update(
			@PathVariable long id){
		
		Mensagem mensagem = mensagemService.update(id);
		
		return new ResponseEntity<Mensagem>(
				mensagem, HttpStatus.OK);
	}
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Mensagem> inativar(
			@PathVariable long id){
		
		Mensagem mensagem = mensagemService.inativar(id);
		
		return new ResponseEntity<Mensagem>(
				mensagem, HttpStatus.OK);
	}

}







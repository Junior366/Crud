package br.itb.projeto.CentroArtesMarciais.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.CentroArtesMarciais.model.entity.Categoria;
import br.itb.projeto.CentroArtesMarciais.service.CategoriaService;

@RestController
@RequestMapping("/categoria/")
public class CategoriaController {

	private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> categorias = 
				categoriaService.findAll();

		return new ResponseEntity<List<Categoria>>
						(categorias, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Categoria> create(
			@RequestBody Categoria categoria){
		
		Categoria _categoria = 
				categoriaService.create(categoria);
		
		return new ResponseEntity<Categoria>
					   (_categoria, HttpStatus.OK);
	}

}











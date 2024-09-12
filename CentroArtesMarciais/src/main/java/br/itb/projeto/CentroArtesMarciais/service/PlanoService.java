package br.itb.projeto.CentroArtesMarciais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.CentroArtesMarciais.model.entity.Plano;
import br.itb.projeto.CentroArtesMarciais.model.repository.PlanoRepository;
import jakarta.transaction.Transactional;

@Service
public class PlanoService {
	private PlanoRepository planoRepository;

	public PlanoService(PlanoRepository planoRepository) {
		super();
		this.planoRepository = planoRepository;
	}

	public List<Plano> findAll() {
		List<Plano> Planos = planoRepository.findAll();

		return Planos;
	}

	public Plano findById(long id) {
		Plano plano = planoRepository.findById(id).orElseThrow();

		return plano;
	}
	
	@Transactional
	public Plano create(Plano plano) {
		plano.setStatusPlano("ATIVO");
		return planoRepository.save(plano);
}
	@Transactional
	public Plano inativar(long id) {
		Optional<Plano> _plano = 
				planoRepository.findById(id);
		
		if (_plano.isPresent()) {
			Plano planoAtualizada = _plano.get();
			planoAtualizada.setStatusPlano("INATIVO");
			
			return planoRepository.save(planoAtualizada);
		}
		return null; 
	}
	
	@Transactional
	public Plano reativar(long id) {
		Optional<Plano> _plano = 
				planoRepository.findById(id);
		
		if (_plano.isPresent()) {
			Plano planoAtualizado = _plano.get();
			planoAtualizado.setStatusPlano("ATIVO");
			
			return planoRepository.save(planoAtualizado);
		}
		return null;
 }
}
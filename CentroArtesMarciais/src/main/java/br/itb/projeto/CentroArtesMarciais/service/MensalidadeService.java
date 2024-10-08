package br.itb.projeto.CentroArtesMarciais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.CentroArtesMarciais.model.entity.Mensalidade;
import br.itb.projeto.CentroArtesMarciais.model.repository.MensalidadeRepository;
import jakarta.transaction.Transactional;

@Service
public class MensalidadeService {
	
	private MensalidadeRepository mensalidadeRepository;
	
	public MensalidadeService(MensalidadeRepository mensalidadeRepository) {
		super();
		this.mensalidadeRepository = mensalidadeRepository;

	}

	public List<Mensalidade> findAll() {
		List<Mensalidade> mensalidades = mensalidadeRepository.findAll();

		return mensalidades;
	}

	public Mensalidade findById(long id) {
		Mensalidade mensalidade = mensalidadeRepository.findById(id).orElseThrow();

		return mensalidade;
		
	}
	
	@Transactional
	public Mensalidade create(Mensalidade mensalidade) {
		mensalidade.setStatusMensalidade("ATIVO");
		return mensalidadeRepository.save(mensalidade);
}
	@Transactional
	public Mensalidade inativar(long id) {
		Optional<Mensalidade> _mensalidade = 
				mensalidadeRepository.findById(id);
		
		if (_mensalidade.isPresent()) {
			Mensalidade mensalidadeAtualizada = _mensalidade.get();
			mensalidadeAtualizada.setStatusMensalidade("INATIVO");
			
			return mensalidadeRepository.save(mensalidadeAtualizada);
		}
		return null; 
	}
	
	@Transactional
	public Mensalidade reativar(long id) {
		Optional<Mensalidade> _mensalidade = 
				mensalidadeRepository.findById(id);
		
		if (_mensalidade.isPresent()) {
			Mensalidade mensalidadeAtualizado = _mensalidade.get();
			mensalidadeAtualizado.setStatusMensalidade("ATIVO");
			/*gerei um auto metodo no Mensalidade (Rever) */
			return mensalidadeRepository.save(mensalidadeAtualizado);
		}
		return null;
 }
}


package br.itb.projeto.CentroArtesMarciais.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.CentroArtesMarciais.model.entity.Mensagem;
import br.itb.projeto.CentroArtesMarciais.model.repository.MensagemRepository;
import jakarta.transaction.Transactional;


@Service
public class MensagemService {

	private MensagemRepository mensagemRepository;

	public MensagemService(MensagemRepository mensagemRepository) {
		super();
		this.mensagemRepository = mensagemRepository;
	}
	
	public List<Mensagem> findAll(){
		List<Mensagem> mensagems = mensagemRepository.findAll();
		return mensagems;
	}
	
	public Mensagem findById(long id) {
		Mensagem mensagem = 
				mensagemRepository
				.findById(id).orElseThrow();

		return mensagem;
	}
	
	//jakarta.transaction.Transactional
	@Transactional
	public Mensagem create(Mensagem mensagem) {
		
		mensagem.setDataMensagem(LocalDateTime.now()); 
		mensagem.setStatusMensagem("ATIVO");
		
		return mensagemRepository.save(mensagem);
	}
	
	@Transactional
	public Mensagem update(long id) {
		//java.util.Optional
		Optional<Mensagem> _mensagem = 
				mensagemRepository.findById(id);
		
		if (_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("LIDA");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Mensagem inativar(long id) {
		Optional<Mensagem> _mensagem = 
				mensagemRepository.findById(id);
		
		if (_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("INATIVO");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}
	
}













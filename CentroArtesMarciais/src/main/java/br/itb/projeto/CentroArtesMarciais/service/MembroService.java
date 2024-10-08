package br.itb.projeto.CentroArtesMarciais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.CentroArtesMarciais.model.entity.Membro;
import br.itb.projeto.CentroArtesMarciais.model.repository.MembroRepository;
import jakarta.transaction.Transactional;

@Service
public class MembroService {

	private MembroRepository membroRepository;

	public MembroService(MembroRepository membroRepository) {
		super();
		this.membroRepository = membroRepository;

	}

	public List<Membro> findAll() {
		List<Membro> membros = membroRepository.findAll();

		return membros;
	}

	public Membro findById(long id) {
		Membro membro = membroRepository.findById(id).orElseThrow();

		return membro;
	}
	
	@Transactional
	public Membro create(Membro membro) {
		membro.setStatusMembro("ATIVO");
		return membroRepository.save(membro);
}
	@Transactional
	public Membro inativar(long id) {
		Optional<Membro> _membro = 
				membroRepository.findById(id);
		
		if (_membro.isPresent()) {
			Membro membroAtualizada = _membro.get();
			membroAtualizada.setStatusMembro("INATIVO");
			
			return membroRepository.save(membroAtualizada);
		}
		return null; 
	}
	
	@Transactional
	public Membro reativar(long id) {
		Optional<Membro> _membro = 
				membroRepository.findById(id);
		
		if (_membro.isPresent()) {
			Membro membroAtualizado = _membro.get();
			membroAtualizado.setStatusMembro("ATIVO");
			
			return membroRepository.save(membroAtualizado);
		}
		return null;
 }
}

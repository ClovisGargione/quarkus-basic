package com.github.clovisgargione.quarkussocial.adapters.out;

import static java.util.Objects.nonNull;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.UserRepository;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.entity.UserEntity;
import com.github.clovisgargione.quarkussocial.application.ports.out.DeleteUserOutputPort;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class DeleteUserAdapter implements DeleteUserOutputPort {

	@Inject
	private UserRepository repository;
	
	@Override
	@Transactional
	public void delete(Long id) throws UserException {
		UserEntity userEntity = repository.findById(id);
		if(nonNull(userEntity)) {
			repository.delete(userEntity);
		} else {
			throw new UserException("Usuário não encontrado");			
		}
	}

}

package com.github.clovisgargione.quarkussocial.adapters.out;

import static java.util.Objects.isNull;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.UserRepository;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.entity.UserEntity;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.mapper.UserEntityMapper;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.out.FindByIdUserOutputPort;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class FindByIdUserAdapter implements FindByIdUserOutputPort {

	@Inject
	private UserEntityMapper userEntityMapper;

	@Inject
	private UserRepository repository;
	
	@Override
	public User findById(Long id) throws UserException {
		UserEntity userEntity = repository.findById(id);
		if(isNull(userEntity)) {
			throw new UserException("Usuário não encontrado");
		}
		User user = userEntityMapper.toUser(userEntity);
		return user;
	}
}

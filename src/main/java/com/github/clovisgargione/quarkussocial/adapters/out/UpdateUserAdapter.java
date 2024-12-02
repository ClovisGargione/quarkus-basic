package com.github.clovisgargione.quarkussocial.adapters.out;

import static java.util.Objects.nonNull;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.UserRepository;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.entity.UserEntity;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.mapper.UserEntityMapper;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.out.UpdateUserOutputPort;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class UpdateUserAdapter implements UpdateUserOutputPort{
	
	@Inject
	private UserEntityMapper userEntityMapper;
	
	@Inject
	private UserRepository repository;

	@Override
	@Transactional
	public User update(Long id, User user) throws UserException {
		UserEntity userEntity = repository.findById(id);
		if(nonNull(userEntity)) {
			userEntity.setName(user.getName());
			userEntity.setAge(user.getAge());
		} else {
			throw new UserException("Usuário não encontrado");			
		}
		User userUpdated = userEntityMapper.toUser(userEntity);
		return userUpdated;
	}

}

package com.github.clovisgargione.quarkussocial.adapters.out;

import com.github.clovisgargione.quarkussocial.adapters.out.repository.UserRepository;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.mapper.UserEntityMapper;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.out.InsertUserOutputPort;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@Singleton
public class InsertUserAdapter implements InsertUserOutputPort {

	@Inject
	private UserEntityMapper userEntityMapper;

	@Inject
	private UserRepository repository;

	@Override
	@Transactional
	public User insert(User user) {
		var userEntity = userEntityMapper.toUserEntity(user);
		repository.persist(userEntity);
		User newUser = userEntityMapper.toUser(userEntity);
		return newUser;
	}
}

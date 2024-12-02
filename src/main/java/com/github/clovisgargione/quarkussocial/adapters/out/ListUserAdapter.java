package com.github.clovisgargione.quarkussocial.adapters.out;

import java.util.List;
import java.util.stream.Collectors;

import com.github.clovisgargione.quarkussocial.adapters.out.repository.UserRepository;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.entity.UserEntity;
import com.github.clovisgargione.quarkussocial.adapters.out.repository.mapper.UserEntityMapper;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.out.ListUserOutputPort;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ListUserAdapter implements ListUserOutputPort {

	@Inject
	private UserEntityMapper userEntityMapper;
	
	@Inject
	private UserRepository repository;
	
	@Override
	public List<User> listUsers() {
		PanacheQuery<UserEntity> usersEntity = repository.findAll();
		return usersEntity.list().stream().map(ue ->  userEntityMapper.toUser(ue)).collect(Collectors.toList());
	}

}

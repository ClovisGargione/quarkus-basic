package com.github.clovisgargione.quarkussocial.adapters.out.repository;

import com.github.clovisgargione.quarkussocial.adapters.out.repository.entity.UserEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity>{

}

package com.github.clovisgargione.quarkussocial.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.github.clovisgargione.quarkussocial.adapters.out.repository.entity.UserEntity;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.config.QuarkusMappingConfig;

@Mapper(config = QuarkusMappingConfig.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserEntityMapper {

	UserEntity toUserEntity(User user);
	
	User toUser(UserEntity userEntity);
}

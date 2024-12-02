package com.github.clovisgargione.quarkussocial.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.github.clovisgargione.quarkussocial.adapters.in.controller.request.UserRequest;
import com.github.clovisgargione.quarkussocial.adapters.in.controller.response.UserResponse;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.config.QuarkusMappingConfig;

@Mapper(config = QuarkusMappingConfig.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

	@Mapping(target="id", ignore = true)
	User toUser(UserRequest userRequest);
	
	UserResponse toUserResponse(User user);
}

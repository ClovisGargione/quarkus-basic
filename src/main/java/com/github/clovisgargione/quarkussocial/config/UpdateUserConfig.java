package com.github.clovisgargione.quarkussocial.config;

import com.github.clovisgargione.quarkussocial.adapters.out.UpdateUserAdapter;
import com.github.clovisgargione.quarkussocial.application.core.usecase.UpdateUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class UpdateUserConfig {
	
	@Produces
	UpdateUserUseCase updateUserUseCase(UpdateUserAdapter updateUserAdapter) {
		return new UpdateUserUseCase(updateUserAdapter);
	}

}

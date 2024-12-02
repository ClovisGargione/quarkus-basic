package com.github.clovisgargione.quarkussocial.config;

import com.github.clovisgargione.quarkussocial.adapters.out.DeleteUserAdapter;
import com.github.clovisgargione.quarkussocial.application.core.usecase.DeleteUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class DeleteUserConfig {

	@Produces
	DeleteUserUseCase deleteUserUseCase(DeleteUserAdapter deleteUserAdapter){
		return new DeleteUserUseCase(deleteUserAdapter);
	}
}

package com.github.clovisgargione.quarkussocial.config;

import com.github.clovisgargione.quarkussocial.adapters.out.FindByIdUserAdapter;
import com.github.clovisgargione.quarkussocial.application.core.usecase.FindByIdUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class FindByIdUserConfig {

	@Produces
	FindByIdUserUseCase findByIdUserUseCase(FindByIdUserAdapter findByIdUserAdapter) {
		return new FindByIdUserUseCase(findByIdUserAdapter);
	}
}

package com.github.clovisgargione.quarkussocial.config;

import com.github.clovisgargione.quarkussocial.adapters.out.InsertUserAdapter;
import com.github.clovisgargione.quarkussocial.application.core.usecase.InsertUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class InsertUserConfig {

	@Produces
	InsertUserUseCase insertUserUseCase(InsertUserAdapter insertUserAdapter) {
		return new InsertUserUseCase(insertUserAdapter);
	}
}

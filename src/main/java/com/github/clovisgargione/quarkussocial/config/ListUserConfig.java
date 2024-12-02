package com.github.clovisgargione.quarkussocial.config;

import com.github.clovisgargione.quarkussocial.adapters.out.ListUserAdapter;
import com.github.clovisgargione.quarkussocial.application.core.usecase.ListUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ListUserConfig {

	@Produces
	ListUserUseCase listUserUseCase(ListUserAdapter listUserAdapter) {
		return new ListUserUseCase(listUserAdapter);
	}
}

package com.github.clovisgargione.quarkussocial.application.core.usecase;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.in.FindByIdUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.out.FindByIdUserOutputPort;

public class FindByIdUserUseCase implements FindByIdUserInputPort {

	private final FindByIdUserOutputPort findByIdUserOutputPort;
	
	
	public FindByIdUserUseCase(FindByIdUserOutputPort findByIdUserOutputPort) {
		super();
		this.findByIdUserOutputPort = findByIdUserOutputPort;
	}


	@Override
	public User findById(Long id) throws UserException {
		User user = findByIdUserOutputPort.findById(id);
		return user;
	}

}

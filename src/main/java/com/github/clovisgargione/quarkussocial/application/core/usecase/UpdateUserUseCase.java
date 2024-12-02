package com.github.clovisgargione.quarkussocial.application.core.usecase;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.in.UpdateUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.out.UpdateUserOutputPort;

public class UpdateUserUseCase implements UpdateUserInputPort {

	private final UpdateUserOutputPort updateUserOutputPort;
	
	public UpdateUserUseCase(UpdateUserOutputPort updateUserOutputPort) {
		super();
		this.updateUserOutputPort = updateUserOutputPort;
	}

	@Override
	public User update(Long id, User user) throws UserException {
		User userUpdated = updateUserOutputPort.update(id, user);
		return userUpdated;
	}

}

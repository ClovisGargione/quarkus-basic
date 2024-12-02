package com.github.clovisgargione.quarkussocial.application.core.usecase;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.application.ports.in.DeleteUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.out.DeleteUserOutputPort;

public class DeleteUserUseCase implements DeleteUserInputPort {

	private final DeleteUserOutputPort deleteUserOutputPort;
		
	public DeleteUserUseCase(DeleteUserOutputPort deleteUserOutputPort) {
		super();
		this.deleteUserOutputPort = deleteUserOutputPort;
	}

	@Override
	public void delete(Long id) throws UserException {
		deleteUserOutputPort.delete(id);
	}

}

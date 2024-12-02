package com.github.clovisgargione.quarkussocial.application.core.usecase;

import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.in.InsertUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.out.InsertUserOutputPort;

public class InsertUserUseCase implements InsertUserInputPort{

	private final InsertUserOutputPort insertUserOutputPort;
	
	public InsertUserUseCase(InsertUserOutputPort insertUserOutputPort) {
		super();
		this.insertUserOutputPort = insertUserOutputPort;
	}

	@Override
	public User insert(User user) {
		User newUser = insertUserOutputPort.insert(user);
		return newUser;
	}

}

package com.github.clovisgargione.quarkussocial.application.core.usecase;

import java.util.List;

import com.github.clovisgargione.quarkussocial.application.core.domain.User;
import com.github.clovisgargione.quarkussocial.application.ports.in.ListUserInputPort;
import com.github.clovisgargione.quarkussocial.application.ports.out.ListUserOutputPort;

public class ListUserUseCase implements ListUserInputPort{

	private final ListUserOutputPort listUserOutputPort;
	
	public ListUserUseCase(ListUserOutputPort listUserOutputPort) {
		super();
		this.listUserOutputPort = listUserOutputPort;
	}

	@Override
	public List<User> listUsers() {
		return listUserOutputPort.listUsers();
	}

}

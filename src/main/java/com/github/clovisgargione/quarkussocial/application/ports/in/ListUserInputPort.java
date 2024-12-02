package com.github.clovisgargione.quarkussocial.application.ports.in;

import java.util.List;

import com.github.clovisgargione.quarkussocial.application.core.domain.User;

public interface ListUserInputPort {

	List<User> listUsers();
	
}

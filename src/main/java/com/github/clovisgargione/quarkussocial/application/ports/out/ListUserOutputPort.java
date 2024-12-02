package com.github.clovisgargione.quarkussocial.application.ports.out;

import java.util.List;

import com.github.clovisgargione.quarkussocial.application.core.domain.User;

public interface ListUserOutputPort {

	List<User> listUsers();
}

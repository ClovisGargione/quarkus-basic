package com.github.clovisgargione.quarkussocial.application.ports.out;

import com.github.clovisgargione.quarkussocial.application.core.domain.User;

public interface InsertUserOutputPort {
	
	User insert(User user);
}

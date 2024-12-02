package com.github.clovisgargione.quarkussocial.application.ports.in;

import com.github.clovisgargione.quarkussocial.application.core.domain.User;

public interface InsertUserInputPort {

	User insert(User user);
}

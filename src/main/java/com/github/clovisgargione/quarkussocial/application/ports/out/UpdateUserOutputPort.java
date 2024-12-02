package com.github.clovisgargione.quarkussocial.application.ports.out;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;

public interface UpdateUserOutputPort {

	User update(Long id, User user) throws UserException;
}

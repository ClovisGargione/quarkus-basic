package com.github.clovisgargione.quarkussocial.application.ports.out;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;

public interface DeleteUserOutputPort {

	void delete(Long id) throws UserException;
}

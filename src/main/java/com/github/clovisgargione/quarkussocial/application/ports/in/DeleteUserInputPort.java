package com.github.clovisgargione.quarkussocial.application.ports.in;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;

public interface DeleteUserInputPort {

	void delete(Long id) throws UserException;
}

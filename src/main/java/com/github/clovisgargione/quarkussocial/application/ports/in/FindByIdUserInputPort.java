package com.github.clovisgargione.quarkussocial.application.ports.in;

import com.github.clovisgargione.quarkussocial.adapters.out.exception.UserException;
import com.github.clovisgargione.quarkussocial.application.core.domain.User;

public interface FindByIdUserInputPort {

	User findById(Long id) throws UserException;
}
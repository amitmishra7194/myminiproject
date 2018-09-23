package com.amit.validator;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.nt.command.UserCommand;
@Named("validator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		
		UserCommand command=null;
		command=(UserCommand)cmd;
		if(command.getUser().equals(""))
			errors.rejectValue("user", "user.required");
        if(command.getPwd().length()==0)
		errors.rejectValue("pwd", "pwd.required");
	}

}

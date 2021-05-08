package business.concretes;

import java.util.regex.Pattern;

import business.abstracts.UserValidationService;
import core.Utils.ServiceUtils;
import core.Utils.conts.ValidationMessages;
import core.Utils.result.ErrorResult;
import core.Utils.result.Result;
import core.Utils.result.SuccessResult;
import entity.concretes.User;

public class UserValidationManager implements UserValidationService{
	
	 public UserValidationManager() {
		
	}
	
	@Override
	public void validate(User user) throws Exception {
		Result[] results = ServiceUtils.runValidates(this.checkFirstNameNotNull(user.getFirstName()),
				this.checkLastNameNotNull(user.getLastName()), this.checkEmailNotNull(user.getEmail()),
				this.checkPasswordNotNull(user.getPassword()), this.checkPasswordMinLength(user.getPassword()),
				this.checkEmailIsValid(user.getEmail()), this.checkFirstNameMinLength(user.getFirstName()),
				this.checkLastNameMinLength(user.getLastName()));
		for (Result result : results) {
			if (!result.isSuccess()) {
				throw new Exception(result.getMessage());
			}
		}
	}
	
	private Result checkFirstNameNotNull(String firstName) {
		if (firstName.isEmpty() || firstName == null) {
			return new ErrorResult(ValidationMessages.firstNameCanNotBeNullOrEmpty);
		}
		return new SuccessResult();
	}

	private Result checkLastNameNotNull(String lastName) {
		if (lastName.isEmpty() || lastName == null) {
			return new ErrorResult(ValidationMessages.lastNameCanNotBeNullOrEmpty);
		}
		return new SuccessResult();
	}

	private Result checkEmailNotNull(String email) {
		if (email.isEmpty() || email == null) {
			return new ErrorResult(ValidationMessages.emailCanNotBeNullOrEmpty);
		}
		return new SuccessResult();
	}

	private Result checkPasswordNotNull(String password) {
		if (password.isEmpty() || password == null) {
			return new ErrorResult(ValidationMessages.passwordCanNotBeNullOrEmpty);
		}
		return new SuccessResult();
	}

	private Result checkPasswordMinLength(String password) {
		if (password.length() < 6) {
			return new ErrorResult(ValidationMessages.passwordLeastCharacter.replace("`n`", "6"));
		}
		return new SuccessResult();
	}

	private Result checkEmailIsValid(String email) {
		String regexString = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		if (!Pattern.compile(regexString).matcher(email).matches()) {
			return new ErrorResult(ValidationMessages.emailNotValid);
		}
		return new SuccessResult();
	}

	private Result checkFirstNameMinLength(String firstName) {
		if (firstName.length() < 2) {
			return new ErrorResult(ValidationMessages.firstNameLeastCharacter);
		}
		return new SuccessResult();
	}

	private Result checkLastNameMinLength(String lastName) {
		if (lastName.length() < 2) {
			return new ErrorResult(ValidationMessages.lastNameLeastCharacter);
		}
		return new SuccessResult();
	}







}

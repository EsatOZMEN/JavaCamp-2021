package business.abstracts;

import entity.concretes.User;

public interface UserValidationService {
	
	public void validate(User user) throws Exception;

}

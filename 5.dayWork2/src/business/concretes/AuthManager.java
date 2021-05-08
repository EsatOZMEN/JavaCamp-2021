package business.concretes;

import business.abstracts.AuthService;
import core.Utils.conts.ValidationMessages;
import core.Utils.security.SingUpService;
import dataAccess.abstracts.UserDao;
import entity.concretes.User;

public class AuthManager implements AuthService {
	private UserDao userDao;
	private SingUpService singUpService;
	
	public AuthManager(UserDao userDao, SingUpService singUpService) {
		this.singUpService=singUpService;
		this.userDao=userDao;
	}

	public void login(String email, String password) {

		if(this.userDao.get(u -> u.getEmail() == email && u.getPassword() == password) != null) {
			System.out.println(ValidationMessages.userLoggedIn);
		}else {
			System.out.println(ValidationMessages.userEmailOrPasswordNotFound);
		}
	}

	public void register(User user) {
		this.singUpService.register(user);
	}
}

import business.abstracts.AuthService;
import business.abstracts.UserActivationService;
import business.abstracts.UserChechService;
import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import business.concretes.AuthManager;
import business.concretes.UserActivationManager;
import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import business.concretes.UserValidationManager;
import core.Utils.mail.CustomMailManager;
import core.Utils.mail.MailService;
import core.Utils.security.googleSingUp.GoogleSingUpManagerAdapter;
import dataAccess.abstracts.UserActivationDao;
import dataAccess.abstracts.UserDao;
import dataAccess.inMemory.InMemoryUserActivationDao;
import dataAccess.inMemory.InMemoryUserdao;
import entity.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserDao userDao = new InMemoryUserdao();
		UserValidationService userValidationService = new UserValidationManager();
		UserChechService userCheckService = new UserCheckManager(userDao);
		
		UserActivationDao userActivationDao = new InMemoryUserActivationDao();
		MailService mailService = new CustomMailManager();	
		UserActivationService userActivationService = new UserActivationManager(userDao, userActivationDao, mailService);
		
		UserService userService = new UserManager(userDao, userValidationService, userCheckService, userActivationService);
		
		User user = new User(1, "Esat", "ÖZMEN", "deneme@gmail.com", "1236456789", true);
				
		
		AuthService authService = new AuthManager(userDao, new GoogleSingUpManagerAdapter(userService));
		authService.register(user);
		
		userActivationService.check("2e315ebc-a2e1-48db-b250-cf560a845e22");

		authService.login("deneme@gmail.com", "123645679");

	}

}

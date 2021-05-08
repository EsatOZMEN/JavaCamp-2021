package core.Utils.security.googleSingUp;

import business.abstracts.BaseSinpUpManager;
import business.abstracts.UserService;
import core.Utils.conts.ValidationMessages;
import entity.concretes.User;
import googleSingUp.GoogleSingUpManager;

public class GoogleSingUpManagerAdapter extends BaseSinpUpManager {
	
	 public GoogleSingUpManagerAdapter(UserService userService) {
		super(userService);
	}
	
	@Override
	public void register(User user) {
		GoogleSingUpManager googleSingUpManager = new GoogleSingUpManager();
		boolean result = googleSingUpManager.login(user.getEmail());
		if (result) {
			super.register(user);
			System.out.println(ValidationMessages.googleSignUpSuccessful);
			
		}else {
			System.out.println(ValidationMessages.googleSignUpFailed);
		}
	}
		
}

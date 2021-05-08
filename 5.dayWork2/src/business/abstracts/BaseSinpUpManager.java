package business.abstracts;

import core.Utils.security.SingUpService;
import entity.concretes.User;

public abstract class BaseSinpUpManager implements SingUpService {
	
	private UserService userService;
	
	public BaseSinpUpManager(UserService userService) {
		
		this.userService=userService;
	}

	
	
	@Override
	public void register(User user) {
		this.userService.add(user);
		
	}

}

package business.concretes;

import business.abstracts.BaseSinpUpManager;
import business.abstracts.UserService;

public class DefaultSingupManager extends BaseSinpUpManager {
	public DefaultSingupManager(UserService userService) {
		super(userService);
	}

}

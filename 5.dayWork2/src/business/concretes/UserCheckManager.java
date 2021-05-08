package business.concretes;

import business.abstracts.UserChechService;
import core.Utils.ServiceUtils;
import core.Utils.result.Result;
import core.Utils.result.SuccessResult;
import dataAccess.abstracts.UserDao;
import entity.concretes.User;

public class UserCheckManager implements UserChechService{
	
	private UserDao userDao;
	

	public UserCheckManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void chech(User user) throws Exception {
		Result[] results = ServiceUtils.runChecks(this.checkDublicateEmail(user.getEmail()));
		for (Result result : results) {
			if(!result.isSuccess()) {
				throw new Exception(result.getMessage());
			}
		}
		
	}


	private Result checkDublicateEmail(String email) {
		if (this.userDao.get(u -> u.getEmail()==email) != null) {
			
		}
		return new SuccessResult();
	}

}

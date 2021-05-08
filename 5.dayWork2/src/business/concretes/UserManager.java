package business.concretes;

import java.util.List;
import java.util.function.Predicate;

import business.abstracts.UserActivationService;
import business.abstracts.UserChechService;
import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import dataAccess.abstracts.UserDao;
import entity.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private UserValidationService userValidationService;
	private UserChechService usercheckService;
	private UserActivationService userActivationservice;
	
	

	public UserManager(UserDao userDao, UserValidationService userValidationService, UserChechService usercheckService,
			UserActivationService userActivationservice) {
		super();
		this.userDao = userDao;
		this.userValidationService = userValidationService;
		this.usercheckService = usercheckService;
		this.userActivationservice = userActivationservice;
	}

	@Override
	public void add(User user) {
		boolean thrown = false;
		try {
			this.userValidationService.validate(user);
			this.usercheckService.chech(user);
			
		} catch (Exception e) {
			thrown=true;
			e.printStackTrace();
		}finally {
			if (!thrown) {
				this.userDao.add(user);
				System.out.println("User Created  :"+ user.toString());
				this.userActivationservice.add(user);
				
			}
		}
		
	}

	@Override
	public void update(User user) {
		this.userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		
	}

	@Override
	public User get(Predicate<User> predicate) {
		return this.get(predicate);
	}

	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}

	@Override
	public List<User> getAll(Predicate<User> predicate) {
		return this.userDao.getAll(predicate);
	}

}

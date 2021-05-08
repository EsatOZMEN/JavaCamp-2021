package business.concretes;

import java.util.UUID;

import business.abstracts.UserActivationService;
import business.consts.Environment;
import core.Utils.conts.ValidationMessages;
import core.Utils.mail.MailService;
import dataAccess.abstracts.UserActivationDao;
import dataAccess.abstracts.UserDao;
import entity.concretes.User;
import entity.concretes.UserActivation;

public class UserActivationManager implements UserActivationService {
	 
	private UserDao userDao;
	private UserActivationDao useractivationDao;
	private MailService mailService;
	
	
	
	public UserActivationManager(UserDao userDao, UserActivationDao useractivationDao, MailService mailService) {
		super();
		this.userDao = userDao;
		this.useractivationDao = useractivationDao;
		this.mailService = mailService;
	}

	@Override
	public void add(User user) {
		UUID uuid = UUID.randomUUID();
		String activationCode = uuid.toString();
		
		this.useractivationDao.add(new UserActivation(1, user.getId(), activationCode));
		this.mailService.sendMail(user.getEmail(), Environment.url+Environment.activationPath+activationCode);
		
	}

	@Override
	public void check(String ActivationCode) {
		UserActivation userActivation = this.useractivationDao.get(u -> u.getActivationCode() == ActivationCode);
		if (userActivation != null) {
			int userId = userActivation.getUserId();
			User user = this.userDao.get(u -> u.getId() == userId);
			user.setActive(true);
			this.userDao.update(user);
			System.out.println(ValidationMessages.userActivated
					);
			
		}else {
			System.out.println(ValidationMessages.activationCodeNotFound);
		}
		
	}

}

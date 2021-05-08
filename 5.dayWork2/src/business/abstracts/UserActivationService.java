package business.abstracts;

import entity.concretes.User;

public interface UserActivationService {
	public void add(User user);
	public void check(String ActivationCode);

}

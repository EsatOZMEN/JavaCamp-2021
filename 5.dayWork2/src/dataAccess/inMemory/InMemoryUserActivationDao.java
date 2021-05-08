package dataAccess.inMemory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import dataAccess.abstracts.UserActivationDao;
import entity.concretes.UserActivation;

public class InMemoryUserActivationDao implements UserActivationDao{

	private List<UserActivation> userActivationArrayList;
	
	public InMemoryUserActivationDao() {
		this.userActivationArrayList = new ArrayList<UserActivation>();
	}
	
	
	
	@Override
	public void add(UserActivation userActivation) {
		this.userActivationArrayList= new ArrayList<UserActivation>();
	}

	@Override
	public void update(UserActivation userActivation) {
		this.userActivationArrayList.set(this.userActivationArrayList.indexOf(userActivation), userActivation);
		
	}

	@Override
	public void delete(UserActivation userActivation) {
		this.userActivationArrayList.remove(this.userActivationArrayList.indexOf(userActivation));
		
	}

	@Override
	public UserActivation get(Predicate<UserActivation> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserActivation> getAll() {
		return this.userActivationArrayList.stream().collect(Collectors.toList());
	}

	@Override
	public List<UserActivation> getAll(Predicate<UserActivation> predicate) {
		return this.userActivationArrayList.stream().filter(predicate).collect(Collectors.toList());
	}

}

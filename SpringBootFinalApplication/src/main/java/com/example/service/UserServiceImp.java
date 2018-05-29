package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.User;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;

	public void createUser(User user) {
		userRepository.save(user);
	}

	public List<User> getUser() {
		return (List<User>) userRepository.findAll();
	}

	public User findById(long id) {
		return userRepository.findOne(id);
	}

	public User update(User user, long l) {
		return userRepository.save(user);
	}

	public void deleteUserById(long id) {
		userRepository.delete(id);
	}

	public User updatePartially(long id) {
		User usr = findById(id);
		usr.setCountry("Japan");
		return userRepository.save(usr);
	}

	@Override
	public void UpdateUserById(String userName, Long id) {
		userRepository.updateUserById(userName, id);
	}
}

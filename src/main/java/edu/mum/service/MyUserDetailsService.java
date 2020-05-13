package edu.mum.service;

import org.slf4j.Logger;
import edu.mum.domain.MyUserDetail;
import edu.mum.domain.UserProfile;
import edu.mum.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserProfile user = userRepository.getUserByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		String password = "123456";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		logger.info("Name = " + user.getPassword() + " ,Password = " + hashedPassword);

		return new MyUserDetail(user);
	}

}
 
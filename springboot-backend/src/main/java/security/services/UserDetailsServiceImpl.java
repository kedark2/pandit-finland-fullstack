package security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.User;
import repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	@Transactional
	public UserDetatils loadUsernameByUsername(String username) throws UsernameNotFoundException{
		User user = userRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User Not Found with username "+ username));
		
		return UserDetailsImpl.build(user);
	}

}

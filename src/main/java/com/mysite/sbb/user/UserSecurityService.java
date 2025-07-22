package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<SiteUser> _siteUser = this.userRepository.findByUsername(username);

		if (_siteUser.isEmpty())
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");

		SiteUser siteUser = _siteUser.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(returnRole(username));

		return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
	}

	private SimpleGrantedAuthority returnRole(String username) {
		if ("admin".equals(username))
			return new SimpleGrantedAuthority(UserRole.ADMIN.getValue());
		else
			return new SimpleGrantedAuthority(UserRole.USER.getValue());
	}

}

package com.svwpu.mailbirthday.sendmail.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.svwpu.mailbirthday.sendmail.dao.LoginUserDao;
import com.svwpu.mailbirthday.sendmail.model.LoginUser;

@Service("localUserDetailsService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class LocalUserDetailsService implements UserDetailsService {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	LoginUserDao loginUserDao;

	@Override
	public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
		Assert.hasText(userID, "username should not be null");
		// Init
		LoginUser loginUser = loginUserDao.getByUserID(userID);

		if (loginUser == null) {
			logger.debug("用户：{} 不存在。", userID);
			throw new UsernameNotFoundException("用户：" + userID + " 不存在。");
		}

		String username = loginUser.getUserID();
		String password = loginUser.getUserPWD();
		String roleType = loginUser.getRoleType();
		RoleType role = RoleType.parseRoleType(roleType);
		Collection<? extends GrantedAuthority> roles = getGrantedAuthorities(role);
		Assert.notEmpty(roles, "GrantedAuthorities should not be empty");

		// 暂时不考虑LocalUserDetails的enable等属性
		UserDetails userDetails = new LocalUserDetails(username, password, roles);
		return userDetails;
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(RoleType role) {
		Set<LocalGrantedAuthority> roles = new HashSet<LocalGrantedAuthority>();
		// 添加默认角色-普通用户
		roles.add(new LocalGrantedAuthority(RoleType.ROLE_USER));
		// 添加自身角色
		roles.add(new LocalGrantedAuthority(role));

		// switch (role) {
		// case ROLE_ADMIN:
		// case ROLE_INFOCONTACTER:
		// case ROLE_MANAGER:
		// case ROLE_PUSEMPLOYEE:
		// case ROLE_PUSMANAGER:
		// case ROLE_PUSOPERATOR:
		// }

		Assert.notEmpty(roles, "GrantedAuthorities should not be empty");
		return roles;
	}
}

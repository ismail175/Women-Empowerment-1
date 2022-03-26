package com.javachinna.config;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import com.javachinna.model.Profession;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.javachinna.model.Role;
import com.javachinna.model.User;
import com.javachinna.repo.RoleRepository;
import com.javachinna.repo.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}
		// Create initial roles
		Role userRole = createRoleIfNotFound(Role.ROLE_USER);
		Role adminRole = createRoleIfNotFound(Role.ROLE_ADMIN);
		createUserIfNotFound("rafed.chraiti@esprit.tn", Set.of(userRole, adminRole));
		createUserIfNotFound("ismail.bouchahoua@esprit.tn", Set.of(userRole, adminRole));
		createUserIfNotFound("chihebeddine.allouche@esprit.tn ", Set.of(userRole, adminRole));
		createUserIfNotFound("youssef.kehili@esprit.tn ", Set.of(userRole, adminRole));
		createUserIfNotFound("mohamedali.guesmi@esprit.tn", Set.of(userRole, adminRole));
		alreadySetup = true;
	}

	@Transactional
	private final User createUserIfNotFound(final String email, Set<Role> roles) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			user = new User();
			user.setDisplayName("Admin");
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode("esprit"));
			user.setRoles(roles);

			user.setEnabled(true);
			Date now = Calendar.getInstance().getTime();
			user.setCreatedDate(now);
			user.setModifiedDate(now);
			user.setProfession (Profession.DOCTOR);
			user = userRepository.save(user);


		}
		return user;
	}

	@Transactional
	private final Role createRoleIfNotFound(final String name) {
		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = roleRepository.save(new Role(name));
		}
		return role;
	}
}
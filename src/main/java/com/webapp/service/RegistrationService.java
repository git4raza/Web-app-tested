package com.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.entity.Registration;
import com.webapp.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	public void saveRegistration(Registration registration) {
		registrationRepository.save(registration);

	}

	public List<Registration> getAllRegistration() {
		return registrationRepository.findAll();
	}

	public void deleteRegById(long id) {
		registrationRepository.deleteById(id);
	}

	public Registration getRegistrationById(long num) {
		Registration reg = registrationRepository.findById(num).get();
		System.out.println(reg);
		return reg;
	}

}

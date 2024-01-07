package com.webapp.controller;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.dto.RegistrationDto;
import com.webapp.dtom.ReadRegistrationDTM;
import com.webapp.dtom.RegistrationDTM;
import com.webapp.entity.Registration;
import com.webapp.exception.ResourceNotFoundException;
import com.webapp.repository.RegistrationRepository;
@RestController

@RequestMapping("/api/registrations")
public class RestRegistrationController{
	@Autowired
	private  RegistrationRepository registrationRepository;

	//http://localhost:8080/api/registrations/30
	
	
//	@GetMapping
//public List<Registration> getAllReg(){
//List<Registration> registration = registrationRepository.findAll();
//
//return registration;
//}

	
//	@GetMapping
	//	public ResponseEntity<List<Registration>>  getAllReg(){
//		List<Registration> registration = registrationRepository.findAll();
//		return new ResponseEntity<>(registration,HttpStatus.OK);
//		}
	@GetMapping
	public ResponseEntity<ReadRegistrationDTM>  getAllReg(){
		List<Registration> regist= registrationRepository.findAll();
		ReadRegistrationDTM readDTM=new ReadRegistrationDTM();
		readDTM.setRegistrationss(regist);
		readDTM.setMessage("Reading of record is completed");
		return new ResponseEntity<>(readDTM,HttpStatus.OK);
		}
	
	
	//http://localhost:8080/api/registrations?id=47

//	@DeleteMapping("/{id}")
//	public void deleteRegistration(@PathVariable long id) {
//		registrationRepository.deleteById(id);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRegistration(@PathVariable long id) {
	    Optional<Registration> findById = registrationRepository.findById(id);
	    if(findById.isPresent()) {
	    registrationRepository.deleteById(id);
	return new ResponseEntity<>("Record is Deleted!!",HttpStatus.OK);
	}
	    else {
      throw new ResourceNotFoundException("Registration Not Found:-"+id);	    	
	    }
	}    
	
	
	//http://localhost:8080/api/registrations
	
//	@PostMapping
//	public void saveRegistration(@RequestBody Registration registration) {
//		registrationRepository.save(registration);
//		
//	}
	
	
	
//	@PostMapping
//	public ResponseEntity<String> saveRegistration(@RequestBody Registration registration) {
//		registrationRepository.save(registration);
//         return new ResponseEntity<> ("Record is saved!!!", HttpStatus.CREATED);	
//	}
	
	@PostMapping
	public ResponseEntity<?> saveRegistration(@Valid @RequestBody 
			Registration registration, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage()
					,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Registration saveReg = registrationRepository.save(registration);
		RegistrationDTM registrationDTM=new RegistrationDTM();
		registrationDTM.setFirstName(saveReg.getFirstName());
		registrationDTM.setLastName(saveReg.getLastName());
		registrationDTM.setEmail(saveReg.getEmail());
return new ResponseEntity<> (registrationDTM, HttpStatus.CREATED);	

	}
	
	
	
	//http://localhost:8080/api/registrations?id=47
	@PutMapping
	public ResponseEntity<RegistrationDTM> updateRegistration(@RequestParam long id,@RequestBody RegistrationDto registrationDto) {
		Registration registration = registrationRepository.findById(id).get();
		registration.setFirstName(registrationDto.getFirstName());
		registration.setLastName(registrationDto.getLastName());
		registration.setEmail(registrationDto.getEmail());
		registration.setMobile(registrationDto.getMobile());
		Registration updatedReg = registrationRepository.save(registration);
		
		RegistrationDTM registrationDTM=new RegistrationDTM();
		registrationDTM.setFirstName(updatedReg.getFirstName());
		registrationDTM.setLastName(updatedReg.getLastName());
		registrationDTM.setEmail(updatedReg.getEmail());
		return new ResponseEntity<>(registrationDTM, HttpStatus.OK);
	}
	
}


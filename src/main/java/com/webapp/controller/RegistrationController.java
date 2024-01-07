package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.dto.RegistrationDto;
import com.webapp.entity.Registration;
import com.webapp.service.RegistrationService;
import com.webapp.util.EmailService;

@Controller
public class RegistrationController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private RegistrationService registrationService;

	// http://localhost:8080/view-registration-page
	// Handler Method
	@RequestMapping("/view-registration-page")
	public String viewsRegistrationPage() {
		return "New_Registration";

	}

//	@RequestMapping("/saveReg")
//	public String saveRegistration(Registration registration ) {
//	registrationService.saveRegistration(registration);
//	return"New_Registration";
//		
//	}
//	
//	@RequestMapping("/saveReg") 
//	public String saveRegistration(
//@RequestParam("firstName")String fname,
//@RequestParam("lastName") String lname,
//@RequestParam("email") String email,
//@RequestParam("mobile")long mobile,
//ModelMap model
//			){
//		Registration registration=new Registration();
//		registration.setFirstName(fname);
//		registration.setLastName(lname);
//		registration.setEmail(email);
//		registration.setMobile(mobile);
//		registrationService.saveRegistration(registration);
//		model.addAttribute("msg", "Record is saved");
//		return"RegistrationV";
//		}

	@RequestMapping("/saveReg")
	public String saveRegistration(RegistrationDto dto, ModelMap model) {
		Registration registration = new Registration();
		String firstName = dto.getFirstName();
		registration.setFirstName(firstName);
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());

		registrationService.saveRegistration(registration);
		emailService.sendEmail(dto.getEmail(), "Welcome", " I have fixed it");

		model.addAttribute("msg", "Record is saved");
		return "New_Registration";
	}

	@RequestMapping("/getAllReg")
	public String getAllRegistration(Model model) {
		List<Registration> reg = registrationService.getAllRegistration();
		model.addAttribute("reg", reg);
		return "list_registration";
	}

	@RequestMapping("/delete")
	public String deleteRegById(@RequestParam("id") long id, Model model) {
		registrationService.deleteRegById(id);
		List<Registration> reg = registrationService.getAllRegistration();
		model.addAttribute("reg", reg);
		return "list_registration";

	}

	@RequestMapping("/getRegistrationById")
	public String getRegistrationById(@RequestParam("id") long num, Model model) {
		System.out.println(num);
		Registration registration = registrationService.getRegistrationById(num);
		model.addAttribute("reg", registration);
		model.addAttribute("omg", "Please update here!!!");

		return "Update_Registration";
	} 

	@RequestMapping("/updateReg")
	public String updateRegistration(RegistrationDto dto, ModelMap model) {
		Registration registration = new Registration();
		registration.setId(dto.getId());
		registration.setFirstName(dto.getFirstName());
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());
		registrationService.saveRegistration(registration);
		
		model.addAttribute("omg", "Student Info has been Updated!!!");
		return "Update_Registration";
	}
}

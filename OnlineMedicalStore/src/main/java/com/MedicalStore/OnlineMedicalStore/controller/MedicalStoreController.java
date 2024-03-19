package com.MedicalStore.OnlineMedicalStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MedicalStore.OnlineMedicalStore.entity.Medicine;
import com.MedicalStore.OnlineMedicalStore.service.MedicineService;

//import org.springframework.security.core.Authentication;


@Controller
public class MedicalStoreController {
	@Autowired
	private MedicineService service;

	
//	@GetMapping("/login")
//    public String login(Authentication authentication) {
//        if (authentication != null) {
//            return "redirect:/";
//        }
//        return "Login";
//    }
	
@GetMapping("/")
public String home() {
	return "home";
}
@GetMapping("/add_medicine")
public String addMedicine() {
	return "addMedicine";
}
@GetMapping("/available_medicine")
public ModelAndView getAlavailableMedicine() {
	List<Medicine>list=service.getAllMedicine();
//	ModelAndView m=new ModelAndView();
//	m.setViewName("bookList");
//	m.addObject("book",list);
	return new ModelAndView("MedicineList","Medicine",list);
}


//@GetMapping("/available_medicine")
//public String availableMedicine() {
//	return "medicineList";
//}

@GetMapping("/my_medicine")
public ModelAndView getAlavailableMedicine1() {
	List<Medicine>list=service.getAllMedicine();
//	ModelAndView m=new ModelAndView();
//	m.setViewName("bookList");
//	m.addObject("book",list);
	return new ModelAndView("MedicineList","Medicine",list);
}
@RequestMapping("/updatemedicine/{id}")
public String updateBook(@PathVariable("id") int id,Model model) {
	Medicine b=service.updateMedicineById(id);
	model.addAttribute("Medicine",b);
	return "updateMedicine";
}
@RequestMapping("/deleteMedicine/{id}")
public String deleteMedicine(@PathVariable("id")int id) {
	service.deleteById(id);
	return "redirect:/available_medicine";
}


@PostMapping("/save")
public String addBook(@ModelAttribute Medicine b) {
	service.save(b);
	return "redirect:/available_medicine";
}

}





//
//
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-oauth2-client</artifactId>
//</dependency>
//<dependency>
//<groupId>org.springframework.security</groupId>
//<artifactId>spring-security-oauth2-client</artifactId>
//</dependency>


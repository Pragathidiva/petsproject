package com.hcl.pp.actions;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
import com.hcl.pp.service.PetService;
import com.hcl.pp.service.SecurityService;
import com.hcl.pp.service.UserService;


@Controller
@SessionAttributes("sessionuser")
public class PetsAppController {
	@Autowired
	private UserService userService;
	@Autowired
	private PetService petService;
	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/user")
	public String welcome(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/user/add")
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		ModelAndView modelAndView = null;
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("userregn");
		} else {
			userService.addUser(user);
			modelAndView = new ModelAndView("registered");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/user/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "userregn";
	}

	@RequestMapping(value = "/user/authenticate")
	public String authenticateUser(@ModelAttribute("user") User user, Model model) {
		User sessionuser = securityService.authenticateUser(user);
		if (sessionuser != null) {
			model.addAttribute("sessionuser", sessionuser);
			return "pet_home";
		} else {
			return "userregn";
		}
	}

	@RequestMapping(value = "/user/logout")
	public String logout() {
		return "login";
	}

	@RequestMapping(value = "/pets/myPets")
	public String myPets(@ModelAttribute("sessionuser") User user, Model model) {

		Set<Pet> pets = userService.getMyPets(user);
		model.addAttribute("pets", pets);
		return "my_pets";
	}

	@RequestMapping(value = "/pets/petDetail")
	public String petDetail(Model model) {
		model.addAttribute("pet", new Pet());
		return "pet_form";
	}

	@RequestMapping(value = "/pets/addPet")
	public String addPet(@ModelAttribute("pet") Pet pet) {
		petService.savePet(pet);
		return "pet_home";
	}

	@RequestMapping(value = "/pets/buyPet", method = RequestMethod.GET)
	public String buyPet(@ModelAttribute("sessionuser") User user, @RequestParam long petId) {
		Pet pet = petService.getPetById(petId);
		userService.buyPet(pet, user);
		return "pet_home";
	}

	@RequestMapping(value = "/user/registered")
	public String registered(@ModelAttribute("user") User user) {
		return "registered";
	}

	@RequestMapping(value = "/pets")
	public String petHome(Model model) {
		List<Pet> pets = petService.getAllPets();
		model.addAttribute("pets", pets);
		return "pet_home";
	}
}

package poe.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poe.spring.domain.Trajet;
import poe.spring.repository.TrajetRepository;

import java.util.List;

@Controller
@RequestMapping("/trajet")
public class TrajetController {

	@Autowired
	TrajetRepository trajetRepository;

	@GetMapping
	public String list(Model model) {
		List<Trajet> trajets = (List<Trajet>) trajetRepository.findAll();
		model.addAttribute("trajets", trajets);
		return "/trajet/list";
	}

}
package poe.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import poe.spring.api.dto.TrajetDto;
import poe.spring.domain.Trajet;
import poe.spring.repository.TrajetRepository;
import poe.spring.repository.UserRepository;
import poe.spring.service.TrajetManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/trajet")
public class TrajetRestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TrajetRepository trajetRepository;

	@Autowired
	private TrajetManagerService trajetManagerService;

	@PostMapping
	public ResponseEntity save(@RequestBody TrajetDto trajetDto, UriComponentsBuilder b) throws Exception {

		Trajet trajet = trajetManagerService.proposerUnTrajet(
				trajetDto.getConducteurId(),
				trajetDto.getVilleDepart(),
				trajetDto.getVilleArrivee(),
				trajetDto.getDateDepart(),
				trajetDto.getPrix(),
				trajetDto.getNbPlaces()
		);

		UriComponents uriComponents =
				b.path("/{id}").buildAndExpand(trajet.getId());

		return ResponseEntity.created(uriComponents.toUri()).build();

	}

	@GetMapping("/search/{town}")
	public List<Trajet> search(@PathVariable("town") String ville) {
		return trajetRepository.toto('%' + ville + '%');
	}
}

package poe.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poe.spring.domain.Trajet;
import poe.spring.domain.User;

import java.util.List;

@Repository
public interface TrajetRepository extends CrudRepository<Trajet, Long> {


	List<Trajet> findByVilleDepartLikeIgnoreCaseOrVilleArriveeLikeIgnoreCase(String villeDepart, String villeArrivee);

	@Query("select t from Trajet t where villeDepart like :search")
	List<Trajet> rechercherParVilleDepart(@Param("search") String search);



	List<Trajet> findByConducteur(User user);

}

package jr.springframework.repositories;

import jr.springframework.domain.Categorie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {

    Optional<Categorie> findByAfdelingNaam(String afdelingNaam);
}

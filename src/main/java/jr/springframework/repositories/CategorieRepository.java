package jr.springframework.repositories;

import jr.springframework.domain.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
}

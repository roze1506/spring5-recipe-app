package jr.springframework.repositories;

import jr.springframework.domain.Recept;
import org.springframework.data.repository.CrudRepository;

public interface ReceptRepository extends CrudRepository<Recept, Long> {
}

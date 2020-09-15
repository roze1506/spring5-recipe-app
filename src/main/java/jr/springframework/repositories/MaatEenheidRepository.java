package jr.springframework.repositories;

import jr.springframework.domain.MaatEenheid;
import org.springframework.data.repository.CrudRepository;

public interface MaatEenheidRepository extends CrudRepository<MaatEenheid, Long> {
}

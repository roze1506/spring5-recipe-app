package jr.springframework.repositories;

import jr.springframework.domain.MaatEenheid;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MaatEenheidRepository extends CrudRepository<MaatEenheid, Long> {

    Optional<MaatEenheid> findByEenheid(String eenheid);
}

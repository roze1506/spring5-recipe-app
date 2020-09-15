package jr.springframework.repositories;

import jr.springframework.domain.Notitie;
import org.springframework.data.repository.CrudRepository;

public interface NotitieRepository  extends CrudRepository<Notitie, Long> {
}

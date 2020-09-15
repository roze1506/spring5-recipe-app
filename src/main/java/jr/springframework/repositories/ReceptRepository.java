package jr.springframework.repositories;

import jr.springframework.domain.Recept;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceptRepository extends CrudRepository<Recept, Long> {

    @Override
    List<Recept> findAll();
}

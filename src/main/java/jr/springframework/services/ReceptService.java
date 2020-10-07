package jr.springframework.services;

import jr.springframework.domain.Recept;
import jr.springframework.repositories.ReceptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceptService {

    private final ReceptRepository receptRepository;

    public List<Recept> krijgAlleRecepten() {
        log.debug("ReceptService up and running! :D");
        return receptRepository.findAll();
    }

    public Recept krijgRecept(Long id) {
        final Optional<Recept> receptOptional = receptRepository.findById(id);
        if(!receptOptional.isPresent()) {
            throw new EntityNotFoundException("Het recept is niet gevonden op basis van ID " + id + '!');
        }
        return receptOptional.get();
    }
}

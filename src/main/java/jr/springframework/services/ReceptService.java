package jr.springframework.services;

import jr.springframework.domain.Recept;
import jr.springframework.repositories.ReceptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptService {

    private final ReceptRepository receptRepository;

    public ReceptService(ReceptRepository receptRepository) {
        this.receptRepository = receptRepository;
    }

    public List<Recept> krijgAlleRecepten() {
        return receptRepository.findAll();
    }
}

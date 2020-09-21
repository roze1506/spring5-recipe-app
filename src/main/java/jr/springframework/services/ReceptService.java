package jr.springframework.services;

import jr.springframework.domain.Recept;
import jr.springframework.repositories.ReceptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceptService {

    private final ReceptRepository receptRepository;

    public List<Recept> krijgAlleRecepten() {
        log.debug("ReceptService up and running! :D");
        return receptRepository.findAll();
    }
}

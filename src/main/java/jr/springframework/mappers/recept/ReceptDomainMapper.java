package jr.springframework.mappers.recept;

import jr.springframework.domain.Recept;
import jr.springframework.dtos.ReceptDto;
import jr.springframework.repositories.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceptDomainMapper {

    @Autowired
    private ReceptRepository receptRepository;

    public Recept transformNieuwRecept(ReceptDto receptDto) {
        final Recept recept = new Recept();
        return definieerReceptWaardes(receptDto, recept);
    }

    public Recept transformBestaandRecept(Long id, ReceptDto receptDto) {
        final Recept recept = receptRepository.findById(id).get();
        return definieerReceptWaardes(receptDto, recept);
    }

    private Recept definieerReceptWaardes(ReceptDto receptDto, Recept recept) {
        recept.setOmschrijving(receptDto.getOmschrijving());
        recept.setAanwijzingen(receptDto.getAanwijzingen());
        recept.setUrl(receptDto.getUrl());
        recept.setBron(receptDto.getBron());
        recept.setPorties(receptDto.getPorties());
        recept.setKookTijd(receptDto.getKookTijd());
        return recept;
    }
}

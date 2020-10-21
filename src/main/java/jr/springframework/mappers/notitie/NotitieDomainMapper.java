package jr.springframework.mappers.notitie;

import jr.springframework.domain.Notitie;
import jr.springframework.dtos.NotitieDto;
import jr.springframework.repositories.NotitieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotitieDomainMapper {

    @Autowired
    private NotitieRepository notitieRepository;

    public Notitie transformNieuweNotitie(NotitieDto notitieDto) {
        final Notitie notitie = new Notitie();
        notitie.setTekst(notitieDto.getTekst());
        return notitie;
    }

    public Notitie transformBestaandeNotitie(Long id, NotitieDto notitieDto) {
        final Notitie notitie = notitieRepository.findById(id).get();
        notitie.setTekst(notitieDto.getTekst());
        return notitie;
    }
}

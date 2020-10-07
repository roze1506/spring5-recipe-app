package jr.springframework.mappers.notitie;

import jr.springframework.domain.Notitie;
import jr.springframework.dtos.NotitieDto;
import jr.springframework.mappers.recept.ReceptDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class NotitieDtoMapper {

    @Autowired
    private ReceptDtoMapper receptDtoMapper;

    public NotitieDto transform(Notitie notitie) {
        final NotitieDto notitieDto = new NotitieDto();
        notitieDto.setId(notitie.getId());
        notitieDto.setTekst(notitie.getTekst());
        notitieDto.setRecept(receptDtoMapper.transform(notitie.getRecept()));
        return notitieDto;
    }
}

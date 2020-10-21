package jr.springframework.mappers.maateenheid;

import jr.springframework.domain.MaatEenheid;
import jr.springframework.dtos.MaatEenheidDto;
import jr.springframework.repositories.MaatEenheidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MaatEenheidDomainMapper {

    @Autowired
    private MaatEenheidRepository maatEenheidRepository;

    public MaatEenheid transformNieuweMaatEenheid(MaatEenheidDto maatEenheidDto) {
        final MaatEenheid maatEenheid = new MaatEenheid();
        maatEenheid.setEenheid(maatEenheidDto.getEenheid());
        return maatEenheid;
    }

    public MaatEenheid transformBestaandeMaatEenheid(Long id, MaatEenheidDto maatEenheidDto) {
        final MaatEenheid maatEenheid = maatEenheidRepository.findById(id).get();
        maatEenheid.setEenheid(maatEenheidDto.getEenheid());
        return maatEenheid;
    }
}

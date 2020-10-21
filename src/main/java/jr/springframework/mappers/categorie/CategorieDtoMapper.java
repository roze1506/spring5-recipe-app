package jr.springframework.mappers.categorie;

import jr.springframework.domain.Categorie;
import jr.springframework.dtos.CategorieDto;
import jr.springframework.mappers.recept.ReceptDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategorieDtoMapper {

    @Autowired
    private ReceptDtoMapper receptDtoMapper;

    public CategorieDto transform(Categorie categorie) {
        final CategorieDto categorieDto = new CategorieDto();
        categorieDto.setId(categorie.getId());
        categorieDto.setAfdelingNaam(categorie.getAfdelingNaam());
        categorie.getRecepten().stream()
                .map(receptDtoMapper::transform)
                .forEach(receptDto -> categorieDto.addRecept(receptDto));
        return categorieDto;
    }
}

package jr.springframework.mappers.recept;

import jr.springframework.domain.Recept;
import jr.springframework.dtos.ReceptDto;
import jr.springframework.mappers.categorie.CategorieDtoMapper;
import jr.springframework.mappers.ingredient.IngredientDtoMapper;
import jr.springframework.mappers.notitie.NotitieDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceptDtoMapper {

    @Autowired
    private NotitieDtoMapper notitieDtoMapper;
    @Autowired
    private IngredientDtoMapper ingredientDtoMapper;
    @Autowired
    private CategorieDtoMapper categorieDtoMapper;

    public ReceptDto transform(Recept recept) {
        final ReceptDto receptDto = new ReceptDto();
        receptDto.setId(recept.getId());
        receptDto.setOmschrijving(recept.getOmschrijving());
        receptDto.setKookTijd(recept.getKookTijd());
        receptDto.setPorties(recept.getPorties());
        receptDto.setMoeilijkheidsgraad(recept.getMoeilijkheidsgraad().name());
        receptDto.setAanwijzingen(recept.getAanwijzingen());
        receptDto.setBron(recept.getBron());
        receptDto.setUrl(recept.getUrl());
        receptDto.setNotitie(notitieDtoMapper.transform(recept.getNotitie()));
        recept.getIngredienten().stream()
                .map(ingredientDtoMapper::transform)
                .forEach(ingredientDto -> receptDto.addIngredient(ingredientDto));
        recept.getCategorieen().stream()
                .map(categorieDtoMapper::transform)
                .forEach(categorieDto -> receptDto.addCategorie(categorieDto));
        return receptDto;
    }
}

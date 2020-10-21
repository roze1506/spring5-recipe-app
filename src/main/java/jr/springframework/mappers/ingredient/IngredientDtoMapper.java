package jr.springframework.mappers.ingredient;

import jr.springframework.domain.Ingredient;
import jr.springframework.dtos.IngredientDto;
import jr.springframework.mappers.maateenheid.MaatEenheidDtoMapper;
import jr.springframework.mappers.recept.ReceptDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientDtoMapper {

    @Autowired
    private ReceptDtoMapper receptDtoMapper;
    @Autowired
    private MaatEenheidDtoMapper maatEenheidDtoMapper;

    public IngredientDto transform(Ingredient ingredient) {
        final IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setAantal(ingredient.getAantal());
        ingredientDto.setBeschrijving(ingredient.getBeschrijving());
        ingredientDto.setRecept(receptDtoMapper.transform(ingredient.getRecept()));
        ingredientDto.setMaatEenheid(maatEenheidDtoMapper.transform(ingredient.getMaatEenheid()));
        return ingredientDto;
    }
}

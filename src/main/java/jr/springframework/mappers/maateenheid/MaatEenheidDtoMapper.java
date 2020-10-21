package jr.springframework.mappers.maateenheid;

import jr.springframework.domain.MaatEenheid;
import jr.springframework.dtos.MaatEenheidDto;
import jr.springframework.mappers.ingredient.IngredientDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MaatEenheidDtoMapper {

    @Autowired
    private IngredientDtoMapper ingredientDtoMapper;

    public MaatEenheidDto transform(MaatEenheid maatEenheid) {
        final MaatEenheidDto maatEenheidDto = new MaatEenheidDto();
        maatEenheidDto.setId(maatEenheid.getId());
        maatEenheidDto.setEenheid(maatEenheid.getEenheid());
        maatEenheid.getIngredienten().stream()
                .map(ingredientDtoMapper::transform)
                .forEach(ingredientDto -> maatEenheidDto.addIngredient(ingredientDto));
        return maatEenheidDto;
    }
}

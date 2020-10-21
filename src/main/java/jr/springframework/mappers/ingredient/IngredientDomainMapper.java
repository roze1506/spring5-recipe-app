package jr.springframework.mappers.ingredient;

import jr.springframework.domain.Ingredient;
import jr.springframework.dtos.IngredientDto;
import jr.springframework.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientDomainMapper {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient transformNieuwIngredient(IngredientDto ingredientDto) {
        final Ingredient ingredient = new Ingredient();
        return definieerWaardesIngredient(ingredientDto, ingredient);
    }

    public Ingredient transformBestaandIngredient(Long id, IngredientDto ingredientDto) {
        final Ingredient ingredient = ingredientRepository.findById(id).get();
        return definieerWaardesIngredient(ingredientDto, ingredient);
    }

    private Ingredient definieerWaardesIngredient(IngredientDto ingredientDto, Ingredient ingredient) {
        ingredient.setBeschrijving(ingredientDto.getBeschrijving());
        ingredient.setAantal(ingredientDto.getAantal());
        return ingredient;
    }
}

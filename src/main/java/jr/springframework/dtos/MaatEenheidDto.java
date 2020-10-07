package jr.springframework.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class MaatEenheidDto {

    private Long id;

    private String eenheid;

    private List<IngredientDto> ingredienten = new ArrayList<>();

    public List<IngredientDto> getIngredienten() {
        return Collections.unmodifiableList(ingredienten);
    }

    public void addIngredient(IngredientDto ingredientDto) {
        ingredienten.add(ingredientDto);
    }
}

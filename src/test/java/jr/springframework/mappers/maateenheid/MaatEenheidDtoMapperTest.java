package jr.springframework.mappers.maateenheid;

import jr.springframework.domain.Ingredient;
import jr.springframework.domain.MaatEenheid;
import jr.springframework.dtos.IngredientDto;
import jr.springframework.dtos.MaatEenheidDto;
import jr.springframework.mappers.ingredient.IngredientDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class MaatEenheidDtoMapperTest {

    @Mock
    private IngredientDtoMapper ingredientDtoMapper;
    @InjectMocks
    private MaatEenheidDtoMapper maatEenheidDtoMapper;

    @Test
    public void testTransform() {
        // Prepare
        final MaatEenheid maatEenheid = new MaatEenheid();
        maatEenheid.setId(5L);
        maatEenheid.setEenheid("EENHEID");
        final Ingredient ingredient = Mockito.mock(Ingredient.class);
        maatEenheid.addIngredient(ingredient);
        final IngredientDto ingredientDto = Mockito.mock(IngredientDto.class);
        Mockito.when(ingredientDtoMapper.transform(ingredient)).thenReturn(ingredientDto);
        // Execute
        final MaatEenheidDto resultaat = maatEenheidDtoMapper.transform(maatEenheid);
        // Verify
        Mockito.verify(ingredientDtoMapper).transform(ingredient);
        Assertions.assertThat(resultaat.getId()).isEqualTo(5L);
        Assertions.assertThat(resultaat.getEenheid()).isEqualTo("EENHEID");
        Assertions.assertThat(resultaat.getIngredienten()).hasSize(1);
        Assertions.assertThat(resultaat.getIngredienten().get(0)).isEqualTo(ingredientDto);
    }
}
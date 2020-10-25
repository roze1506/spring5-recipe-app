package jr.springframework.mappers.ingredient;

import jr.springframework.domain.Ingredient;
import jr.springframework.dtos.IngredientDto;
import jr.springframework.repositories.IngredientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientDomainMapperTest {

    @Mock
    private IngredientRepository ingredientRepository;
    @InjectMocks
    private IngredientDomainMapper ingredientDomainMapper;

    @Test
    public void testTransformNieuwIngredient() {
        // Prepare
        final IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setAantal(BigDecimal.ONE);
        ingredientDto.setBeschrijving("BESCHRIJVING");
        // Execute
        final Ingredient resultaat = ingredientDomainMapper.transformNieuwIngredient(ingredientDto);
        // Verify
        Assertions.assertThat(resultaat.getAantal()).isEqualTo(BigDecimal.ONE);
        Assertions.assertThat(resultaat.getBeschrijving()).isEqualTo("BESCHRIJVING");
    }

    @Test
    public void testTransformBestaandIngredient() {
        // Prepare
        final Long id = 5L;
        final IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setAantal(BigDecimal.ONE);
        ingredientDto.setBeschrijving("BESCHRIJVING");
        final Ingredient ingredient = new Ingredient();
        ReflectionTestUtils.setField(ingredient, "id", id);
        Mockito.when(ingredientRepository.findById(id)).thenReturn(Optional.of(ingredient));
        // Execute
        final Ingredient resultaat = ingredientDomainMapper.transformBestaandIngredient(id, ingredientDto);
        // Verify
        Mockito.verify(ingredientRepository).findById(id);
        Assertions.assertThat(resultaat.getId()).isEqualTo(id);
        Assertions.assertThat(resultaat.getAantal()).isEqualTo(BigDecimal.ONE);
        Assertions.assertThat(resultaat.getBeschrijving()).isEqualTo("BESCHRIJVING");
    }

}
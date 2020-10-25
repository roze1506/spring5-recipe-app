package jr.springframework.mappers.ingredient;

import jr.springframework.domain.Ingredient;
import jr.springframework.domain.MaatEenheid;
import jr.springframework.domain.Recept;
import jr.springframework.dtos.IngredientDto;
import jr.springframework.dtos.MaatEenheidDto;
import jr.springframework.dtos.ReceptDto;
import jr.springframework.mappers.maateenheid.MaatEenheidDtoMapper;
import jr.springframework.mappers.recept.ReceptDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class IngredientDtoMapperTest {

    @Mock
    private ReceptDtoMapper receptDtoMapper;
    @Mock
    private MaatEenheidDtoMapper maatEenheidDtoMapper;
    @InjectMocks
    private IngredientDtoMapper ingredientDtoMapper;

    @Test
    public void testTransform() {
        // Prepare
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(5L);
        ingredient.setAantal(BigDecimal.TEN);
        ingredient.setBeschrijving("BESCHRIJVING");
        final Recept recept = Mockito.mock(Recept.class);
        ingredient.setRecept(recept);
        final ReceptDto receptDto = Mockito.mock(ReceptDto.class);
        final MaatEenheid maatEenheid = Mockito.mock(MaatEenheid.class);
        ingredient.setMaatEenheid(maatEenheid);
        final MaatEenheidDto maatEenheidDto = Mockito.mock(MaatEenheidDto.class);
        Mockito.when(receptDtoMapper.transform(recept)).thenReturn(receptDto);
        Mockito.when(maatEenheidDtoMapper.transform(maatEenheid)).thenReturn(maatEenheidDto);
        // Execute
        final IngredientDto resultaat = ingredientDtoMapper.transform(ingredient);
        // Verify
        Mockito.verify(receptDtoMapper).transform(recept);
        Mockito.verify(maatEenheidDtoMapper).transform(maatEenheid);
        Assertions.assertThat(resultaat.getId()).isEqualTo(5L);
        Assertions.assertThat(resultaat.getAantal()).isEqualTo(BigDecimal.TEN);
        Assertions.assertThat(resultaat.getBeschrijving()).isEqualTo("BESCHRIJVING");
        Assertions.assertThat(resultaat.getRecept()).isEqualTo(receptDto);
        Assertions.assertThat(resultaat.getMaatEenheid()).isEqualTo(maatEenheidDto);
    }
}
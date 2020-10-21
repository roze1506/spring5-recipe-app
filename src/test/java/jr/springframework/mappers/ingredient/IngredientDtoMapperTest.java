package jr.springframework.mappers.ingredient;

import jr.springframework.mappers.maateenheid.MaatEenheidDtoMapper;
import jr.springframework.mappers.recept.ReceptDtoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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

        // Execute

        // Verify

    }
}
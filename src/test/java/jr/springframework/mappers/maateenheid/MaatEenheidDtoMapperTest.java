package jr.springframework.mappers.maateenheid;

import jr.springframework.mappers.ingredient.IngredientDtoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

        // Execute

        // Verify

    }
}
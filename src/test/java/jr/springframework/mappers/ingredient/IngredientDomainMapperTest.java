package jr.springframework.mappers.ingredient;

import jr.springframework.repositories.IngredientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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

        // Execute

        // Verify

    }

    @Test
    public void testTransformBestaandIngredient() {
        // Prepare

        // Execute

        // Verify

    }

}
package jr.springframework.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class MaatEenheidTest {

    private MaatEenheid maatEenheid;

    @Before
    public void setUp() {
        maatEenheid = new MaatEenheid();
    }

    @Test
    public void testGetEnSetId() {
        // Prepare
        maatEenheid.setId(5L);
        // Execute
        final Long resultaat = maatEenheid.getId();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(5L);
    }

    @Test
    public void testGetEnSetEenheid() {
        // Prepare
        maatEenheid.setEenheid("TESTEENHEID");
        // Execute
        final String resultaat = maatEenheid.getEenheid();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo("TESTEENHEID");
    }

    @Test
    public void testAddIngredient() {
        // Prepare
        final Ingredient testIngredient= new Ingredient();
        // Execute
        maatEenheid.addIngredient(testIngredient);
        // Verify
        Assertions.assertThat(maatEenheid.getIngredienten().size()).isEqualTo(1);
        Assertions.assertThat(maatEenheid.getIngredienten()).contains(testIngredient);
    }

    @Test
    public void testRemoveIngredient() {
        // Prepare
        final Ingredient testIngredient= new Ingredient();
        maatEenheid.addIngredient(testIngredient);
        // Execute
        maatEenheid.removeIngredient(testIngredient);
        // Verify
        Assertions.assertThat(maatEenheid.getIngredienten()).isEmpty();
    }
}

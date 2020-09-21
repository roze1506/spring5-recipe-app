package jr.springframework.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient();
    }

    @Test
    public void testGetEnSetId() {
        // Prepare
        ingredient.setId(5L);
        // Execute
        final Long resultaat = ingredient.getId();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(5L);
    }

    @Test
    public void testGetEnSetBeschrijving() {
        // Prepare
        ingredient.setBeschrijving("TESTBESCHRIJVING");
        // Execute
        final String resultaat = ingredient.getBeschrijving();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo("TESTBESCHRIJVING");
    }

    @Test
    public void testGetEnSetMaatEenheid() {
        // Prepare
        final MaatEenheid testMaatEenheid = new MaatEenheid();
        ingredient.setMaatEenheid(testMaatEenheid);
        // Execute
        final MaatEenheid resultaat = ingredient.getMaatEenheid();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(testMaatEenheid);
    }

    @Test
    public void testGetEnSetRecept() {
        // Prepare
        final Recept testRecept = new Recept();
        ingredient.setRecept(testRecept);
        // Execute
        final Recept resultaat = ingredient.getRecept();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(testRecept);
    }
}

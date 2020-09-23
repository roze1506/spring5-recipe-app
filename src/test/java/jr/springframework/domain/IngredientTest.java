package jr.springframework.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

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
    public void testGetEnSetAantal() {
        // Prepare
        final BigDecimal testAantal = BigDecimal.valueOf(5L);
        ingredient.setAantal(testAantal);
        // Execute
        final BigDecimal resultaat = ingredient.getAantal();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(testAantal);
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

package jr.springframework.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CategorieTest {

    private Categorie categorie;

    @Before
    public void setUp() {
        categorie = new Categorie();
    }

    @Test
    public void testGetEnSetId() {
        // Prepare
        categorie.setId(5L);
        // Execute
        final Long resultaat = categorie.getId();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(5L);
    }

    @Test
    public void testGetEnSetAfdelingNaam() {
        // Prepare
        categorie.setAfdelingNaam("TESTAFDELINGNAAM");
        // Execute
        final String resultaat = categorie.getAfdelingNaam();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo("TESTAFDELINGNAAM");
    }

    @Test
    public void testAddRecept() {
        // Prepare
        final Recept testRecept = new Recept();
        // Execute
        categorie.addRecept(testRecept);
        // Verify
        Assertions.assertThat(categorie.getRecepten().size()).isEqualTo(1);
        Assertions.assertThat(categorie.getRecepten()).contains(testRecept);
    }

    @Test
    public void testRemoveRecept() {
        // Prepare
        final Recept testRecept = new Recept();
        categorie.addRecept(testRecept);
        // Execute
        categorie.removeRecept(testRecept);
        // Verify
        Assertions.assertThat(categorie.getRecepten()).isEmpty();
    }
}

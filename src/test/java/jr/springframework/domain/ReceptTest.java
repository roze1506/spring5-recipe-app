package jr.springframework.domain;

import jr.springframework.enums.Moeilijkheidsgraad;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ReceptTest {

    private Recept recept;

    @Before
    public void setUp() {
        recept = new Recept();
    }

    @Test
    public void testGetEnSetId() {
        // Prepare
        recept.setId(5L);
        // Execute
        final Long resultaat = recept.getId();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(5L);
    }

    @Test
    public void testGetEnSetOmschrijving() {
        // Prepare
        recept.setOmschrijving("TESTOMSCHRIJVING");
        // Execute
        final String resultaat = recept.getOmschrijving();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo("TESTOMSCHRIJVING");
    }

    @Test
    public void testGetEnSetKooktijd() {
        // Prepare
        recept.setKookTijd(5);
        // Execute
        final Integer resultaat = recept.getKookTijd();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(5);
    }

    @Test
    public void testGetEnSetPorties() {
        // Prepare
        recept.setPorties(500);
        // Execute
        final Integer resultaat = recept.getPorties();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(500);
    }

    @Test
    public void testGetEnSetBron() {
        // Prepare
        recept.setBron("TESTBRON");
        // Execute
        final String resultaat = recept.getBron();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo("TESTBRON");
    }

    @Test
    public void testGetEnSetUrl() {
        // Prepare
        recept.setUrl("TESTURL");
        // Execute
        final String resultaat = recept.getUrl();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo("TESTURL");
    }

    @Test
    public void testGetEnSetAanwijzingen() {
        // Prepare
        recept.setAanwijzingen("TESTINSTRUCTIES");
        // Execute
        final String resultaat = recept.getAanwijzingen();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo("TESTINSTRUCTIES");
    }

    @Test
    public void testGetEnSetAfbeelding() {
        // Prepare
        final Byte[] testAfbeelding = new Byte[0];
        recept.setAfbeelding(testAfbeelding);
        // Execute
        final Byte[] resultaat = recept.getAfbeelding();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(testAfbeelding);
    }

    @Test
    public void testGetEnSetMoeilijkheidsgraad() {
        // Prepare
        recept.setMoeilijkheidsgraad(Moeilijkheidsgraad.MOEILIJK);
        // Execute
        final Moeilijkheidsgraad resultaat = recept.getMoeilijkheidsgraad();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(Moeilijkheidsgraad.MOEILIJK);
    }

    @Test
    public void testGetEnSetNotitie() {
        // Prepare
        final Notitie testNotitie = new Notitie();
        recept.setNotitie(testNotitie);
        // Execute
        final Notitie resultaat = recept.getNotitie();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(testNotitie);
    }

    @Test
    public void testAddIngredient() {
        // Prepare
        final Ingredient testIngredient = new Ingredient();
        // Execute
        recept.addIngredient(testIngredient);
        // Verify
        Assertions.assertThat(recept.getIngredienten().size()).isEqualTo(1);
        Assertions.assertThat(recept.getIngredienten()).contains(testIngredient);
    }

    @Test
    public void testRemoveIngredient() {
        // Prepare
        final Ingredient testIngredient = new Ingredient();
        recept.addIngredient(testIngredient);
        // Execute
        recept.removeIngredient(testIngredient);
        // Verify
        Assertions.assertThat(recept.getIngredienten()).isEmpty();
    }

    @Test
    public void testAddCategorie() {
        // Prepare
        final Categorie testCategorie = new Categorie();
        // Execute
        recept.addCategorie(testCategorie);
        // Verify
        Assertions.assertThat(recept.getCategorieen().size()).isEqualTo(1);
        Assertions.assertThat(recept.getCategorieen()).contains(testCategorie);
    }

    @Test
    public void testRemoveCategorie() {
        // Prepare
        final Categorie testCategorie = new Categorie();
        recept.addCategorie(testCategorie);
        // Execute
        recept.removeCategorie(testCategorie);
        // Verify
        Assertions.assertThat(recept.getCategorieen()).isEmpty();
    }
}

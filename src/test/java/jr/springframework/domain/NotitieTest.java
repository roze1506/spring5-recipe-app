package jr.springframework.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class NotitieTest {

    private Notitie notitie;

    @Before
    public void setUp() {
        notitie = new Notitie();
    }

    @Test
    public void testGetEnSetId() {
        // Prepare
        notitie.setId(5L);
        // Execute
        final Long resultaat = notitie.getId();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(5L);
    }

    @Test
    public void testGetEnSetTekst() {
        // Prepare
        notitie.setTekst("TESTTEKST");
        // Execute
        final String resultaat = notitie.getTekst();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo("TESTTEKST");
    }

    @Test
    public void testGetEnSetRecept() {
        // Prepare
        final Recept testRecept = new Recept();
        notitie.setRecept(testRecept);
        // Execute
        final Recept resultaat = notitie.getRecept();
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(testRecept);
    }
}

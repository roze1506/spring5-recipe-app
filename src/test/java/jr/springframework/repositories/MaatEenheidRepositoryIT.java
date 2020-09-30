package jr.springframework.repositories;

import jr.springframework.domain.MaatEenheid;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MaatEenheidRepositoryIT {

    @Autowired
    private MaatEenheidRepository maatEenheidRepository;

    @Test
    public void testFindByEenheidGram() {
        // Execute
        final Optional<MaatEenheid> maatEenheidOptional = maatEenheidRepository.findByEenheid("Gram");
        // Verify
        Assertions.assertThat(maatEenheidOptional.get().getEenheid()).isEqualTo("Gram");
    }

    @Test
    public void testFindByEenheidEetlepel() {
        // Execute
        final Optional<MaatEenheid> maatEenheidOptional = maatEenheidRepository.findByEenheid("Eetlepel");
        // Verify
        Assertions.assertThat(maatEenheidOptional.get().getEenheid()).isEqualTo("Eetlepel");
    }

    @Test
    public void testFindByEenheidAantal() {
        // Execute
        final Optional<MaatEenheid> maatEenheidOptional = maatEenheidRepository.findByEenheid("Aantal");
        // Verify
        Assertions.assertThat(maatEenheidOptional.get().getEenheid()).isEqualTo("Aantal");
    }

    @Test
    public void testFindByEenheidMilliLiter() {
        // Execute
        final Optional<MaatEenheid> maatEenheidOptional = maatEenheidRepository.findByEenheid("MilliLiter");
        // Verify
        Assertions.assertThat(maatEenheidOptional.get().getEenheid()).isEqualTo("MilliLiter");
    }
}

package jr.springframework.repositories;

import jr.springframework.domain.Categorie;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategorieRepositoryIT {

    @Autowired
    private CategorieRepository categorieRepository;

    @Test
    public void testFindByAfdelingNaamPasta() {
        final Optional<Categorie> categorieOptional = categorieRepository.findByAfdelingNaam("Pasta");
        Assertions.assertThat(categorieOptional.get().getAfdelingNaam()).isEqualTo("Pasta");
    }
}

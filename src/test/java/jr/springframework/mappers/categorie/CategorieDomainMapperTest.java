package jr.springframework.mappers.categorie;

import jr.springframework.repositories.CategorieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategorieDomainMapperTest {

    @Mock
    private CategorieRepository categorieRepository;
    @InjectMocks
    private CategorieDomainMapper categorieDomainMapper;

    @Test
    public void testTransformNieuweCategorie() {
        // Prepare

        // Execute

        // Verify

    }

    @Test
    public void testTransformBestaandeCategorie() {
        // Prepare

        // Execute

        // Verify

    }
}
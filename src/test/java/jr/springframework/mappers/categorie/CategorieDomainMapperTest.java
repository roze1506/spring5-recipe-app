package jr.springframework.mappers.categorie;

import jr.springframework.domain.Categorie;
import jr.springframework.dtos.CategorieDto;
import jr.springframework.repositories.CategorieRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CategorieDomainMapperTest {

    @Mock
    private CategorieRepository categorieRepository;
    @InjectMocks
    private CategorieDomainMapper categorieDomainMapper;

    @Test
    public void testTransformNieuweCategorie() {
        // Prepare
        final CategorieDto categorieDto = new CategorieDto();
        categorieDto.setAfdelingNaam("AFDELINGNAAM");
        // Execute
        final Categorie resultaat = categorieDomainMapper.transformNieuweCategorie(categorieDto);
        // Verify
        Assertions.assertThat(resultaat.getAfdelingNaam()).isEqualTo("AFDELINGNAAM");
    }

    @Test
    public void testTransformBestaandeCategorie() {
        // Prepare
        final Long id = 5L;
        final CategorieDto categorieDto = new CategorieDto();
        categorieDto.setAfdelingNaam("AFDELINGNAAM");
        final Categorie categorie = new Categorie();
        ReflectionTestUtils.setField(categorie, "id", id);
        Mockito.when(categorieRepository.findById(id)).thenReturn(Optional.of(categorie));
        // Execute
        final Categorie resultaat = categorieDomainMapper.transformBestaandeCategorie(id, categorieDto);
        // Verify
        Mockito.verify(categorieRepository).findById(id);
        Assertions.assertThat(resultaat.getId()).isEqualTo(id);
        Assertions.assertThat(resultaat.getAfdelingNaam()).isEqualTo("AFDELINGNAAM");
    }
}
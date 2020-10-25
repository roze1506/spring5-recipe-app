package jr.springframework.mappers.categorie;

import jr.springframework.domain.Categorie;
import jr.springframework.domain.Recept;
import jr.springframework.dtos.CategorieDto;
import jr.springframework.dtos.ReceptDto;
import jr.springframework.mappers.recept.ReceptDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategorieDtoMapperTest {

    @Mock
    private ReceptDtoMapper receptDtoMapper;
    @InjectMocks
    private CategorieDtoMapper categorieDtoMapper;

    @Test
    public void testTransform() {
        // Prepare
        final Categorie categorie = new Categorie();
        categorie.setId(5L);
        categorie.setAfdelingNaam("AFDELINGNAAM");
        final Recept recept = Mockito.mock(Recept.class);
        categorie.addRecept(recept);
        final ReceptDto receptDto = Mockito.mock(ReceptDto.class);
        Mockito.when(receptDtoMapper.transform(recept)).thenReturn(receptDto);
        // Execute
        final CategorieDto resultaat = categorieDtoMapper.transform(categorie);
        // Verify
        Mockito.verify(receptDtoMapper).transform(recept);
        Assertions.assertThat(resultaat.getId()).isEqualTo(5L);
        Assertions.assertThat(resultaat.getAfdelingNaam()).isEqualTo("AFDELINGNAAM");
        Assertions.assertThat(resultaat.getRecepten()).hasSize(1);
        Assertions.assertThat(resultaat.getRecepten().get(0)).isEqualTo(receptDto);
    }
}
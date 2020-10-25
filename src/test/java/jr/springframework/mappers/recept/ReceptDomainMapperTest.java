package jr.springframework.mappers.recept;

import jr.springframework.domain.Recept;
import jr.springframework.dtos.ReceptDto;
import jr.springframework.repositories.ReceptRepository;
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
public class ReceptDomainMapperTest {

    @Mock
    private ReceptRepository receptRepository;
    @InjectMocks
    private ReceptDomainMapper receptDomainMapper;

    @Test
    public void testTransformNieuwRecept() {
        // Prepare
        final ReceptDto receptDto = new ReceptDto();
        receptDto.setOmschrijving("OMSCHRIJVING");
        receptDto.setAanwijzingen("AANWIJZINGEN");
        receptDto.setUrl("URL");
        receptDto.setBron("BRON");
        receptDto.setPorties(7);
        receptDto.setKookTijd(10);
        // Execute
        final Recept resultaat = receptDomainMapper.transformNieuwRecept(receptDto);
        // Verify
        Assertions.assertThat(resultaat.getOmschrijving()).isEqualTo("OMSCHRIJVING");
        Assertions.assertThat(resultaat.getAanwijzingen()).isEqualTo("AANWIJZINGEN");
        Assertions.assertThat(resultaat.getUrl()).isEqualTo("URL");
        Assertions.assertThat(resultaat.getBron()).isEqualTo("BRON");
        Assertions.assertThat(resultaat.getPorties()).isEqualTo(7);
        Assertions.assertThat(resultaat.getKookTijd()).isEqualTo(10);
    }

    @Test
    public void testTransformBestaandRecept() {
        // Prepare
        final Long id = 5L;
        final ReceptDto receptDto = new ReceptDto();
        receptDto.setOmschrijving("OMSCHRIJVING");
        receptDto.setAanwijzingen("AANWIJZINGEN");
        receptDto.setUrl("URL");
        receptDto.setBron("BRON");
        receptDto.setPorties(7);
        receptDto.setKookTijd(10);
        final Recept recept = new Recept();
        ReflectionTestUtils.setField(recept, "id", id);
        Mockito.when(receptRepository.findById(5L)).thenReturn(Optional.of(recept));
        // Execute
        final Recept resultaat = receptDomainMapper.transformBestaandRecept(id, receptDto);
        // Verify
        Mockito.verify(receptRepository).findById(id);
        Assertions.assertThat(resultaat.getId()).isEqualTo(id);
        Assertions.assertThat(resultaat.getOmschrijving()).isEqualTo("OMSCHRIJVING");
        Assertions.assertThat(resultaat.getAanwijzingen()).isEqualTo("AANWIJZINGEN");
        Assertions.assertThat(resultaat.getUrl()).isEqualTo("URL");
        Assertions.assertThat(resultaat.getBron()).isEqualTo("BRON");
        Assertions.assertThat(resultaat.getPorties()).isEqualTo(7);
        Assertions.assertThat(resultaat.getKookTijd()).isEqualTo(10);
    }
}
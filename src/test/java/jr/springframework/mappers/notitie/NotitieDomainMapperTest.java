package jr.springframework.mappers.notitie;

import jr.springframework.domain.Notitie;
import jr.springframework.dtos.NotitieDto;
import jr.springframework.repositories.NotitieRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class NotitieDomainMapperTest {

    @Mock
    private NotitieRepository notitieRepository;
    @InjectMocks
    private NotitieDomainMapper notitieDomainMapper;

    @Test
    public void testTransformNieuweNotitie() {
        // Prepare
        final NotitieDto notitieDto = new NotitieDto();
        notitieDto.setTekst("TEKST");
        // Execute
        final Notitie resultaat = notitieDomainMapper.transformNieuweNotitie(notitieDto);
        // Verify
        Assertions.assertThat(resultaat.getTekst()).isEqualTo("TEKST");
    }

    @Test
    public void testTransformBestaandeNotitie() {
        // Prepare
        final Long id = 5L;
        final NotitieDto notitieDto = new NotitieDto();
        notitieDto.setTekst("TEKST");
        final Notitie notitie = new Notitie();
        ReflectionTestUtils.setField(notitie, "id", id);
        Mockito.when(notitieRepository.findById(id)).thenReturn(Optional.of(notitie));
        // Execute
        final Notitie resultaat = notitieDomainMapper.transformBestaandeNotitie(id, notitieDto);
        // Verify
        Mockito.verify(notitieRepository).findById(id);
        Assertions.assertThat(resultaat.getId()).isEqualTo(id);
        Assertions.assertThat(resultaat.getTekst()).isEqualTo("TEKST");
    }

}
package jr.springframework.mappers.notitie;

import jr.springframework.domain.Notitie;
import jr.springframework.domain.Recept;
import jr.springframework.dtos.NotitieDto;
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
public class NotitieDtoMapperTest {

    @Mock
    private ReceptDtoMapper receptDtoMapper;
    @InjectMocks
    private NotitieDtoMapper notitieDtoMapper;

    @Test
    public void testTransform() {
        // Prepare
        final Notitie notitie = new Notitie();
        final Recept recept = Mockito.mock(Recept.class);
        final ReceptDto receptDto = Mockito.mock(ReceptDto.class);
        notitie.setId(5L);
        notitie.setTekst("TEKST");
        notitie.setRecept(recept);
        Mockito.when(receptDtoMapper.transform(recept)).thenReturn(receptDto);
        // Execute
        final NotitieDto resultaat = notitieDtoMapper.transform(notitie);
        // Verify
        Mockito.verify(receptDtoMapper).transform(recept);
        Assertions.assertThat(resultaat.getId()).isEqualTo(5L);
        Assertions.assertThat(resultaat.getTekst()).isEqualTo("TEKST");
        Assertions.assertThat(resultaat.getRecept()).isEqualTo(receptDto);
    }
}
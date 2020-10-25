package jr.springframework.mappers.maateenheid;

import jr.springframework.domain.MaatEenheid;
import jr.springframework.dtos.MaatEenheidDto;
import jr.springframework.repositories.MaatEenheidRepository;
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
public class MaatEenheidDomainMapperTest {

    @Mock
    private MaatEenheidRepository maatEenheidRepository;
    @InjectMocks
    private MaatEenheidDomainMapper maatEenheidDomainMapper;

    @Test
    public void testTransformNieuweMaatEenheid() {
        // Prepare
        final MaatEenheidDto maatEenheidDto = new MaatEenheidDto();
        maatEenheidDto.setEenheid("EENHEID");
        // Execute
        final MaatEenheid resultaat = maatEenheidDomainMapper.transformNieuweMaatEenheid(maatEenheidDto);
        // Verify
        Assertions.assertThat(resultaat.getEenheid()).isEqualTo("EENHEID");
    }

    @Test
    public void testTransformBestaandeMaatEenheid() {
        // Prepare
        final Long id = 5L;
        final MaatEenheidDto maatEenheidDto = new MaatEenheidDto();
        maatEenheidDto.setEenheid("EENHEID");
        final MaatEenheid maatEenheid = new MaatEenheid();
        ReflectionTestUtils.setField(maatEenheid, "id", id);
        Mockito.when(maatEenheidRepository.findById(id)).thenReturn(Optional.of(maatEenheid));
        // Execute
        final MaatEenheid resultaat = maatEenheidDomainMapper.transformBestaandeMaatEenheid(id, maatEenheidDto);
        // Verify
        Mockito.verify(maatEenheidRepository).findById(id);
        Assertions.assertThat(resultaat.getId()).isEqualTo(id);
        Assertions.assertThat(resultaat.getEenheid()).isEqualTo("EENHEID");
    }
}
package jr.springframework.services;

import jr.springframework.domain.Recept;
import jr.springframework.repositories.ReceptRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ReceptServiceTest {

    @Mock
    private ReceptRepository receptRepository;

    @InjectMocks
    private ReceptService receptService;

    @Test
    public void testKrijgAlleRecepten() {
        // Prepare
        final List<Recept> testRecepten = new ArrayList<>();
        final Recept testRecept = Mockito.mock(Recept.class);
        testRecepten.add(testRecept);
        Mockito.when(receptRepository.findAll()).thenReturn(testRecepten);
        // Execute
        final List<Recept> resultaat = receptService.krijgAlleRecepten();
        // Verify
        Assertions.assertThat(resultaat).hasSize(1);
        Assertions.assertThat(resultaat).contains(testRecept);
        Assertions.assertThat(resultaat).isEqualTo(testRecepten);
    }

    @Test
    public void testKrijgRecept() {
        // Prepare
        final Long testId = 5L;
        final Recept testRecept = new Recept();
        testRecept.setId(testId);
        Mockito.when(receptRepository.findById(testId)).thenReturn(Optional.of(testRecept));
        // Execute
        final Recept resultaat = receptService.krijgRecept(testId);
        // Verify
        Assertions.assertThat(resultaat).isEqualTo(testRecept);
    }
}

package jr.springframework.controllers;

import jr.springframework.domain.Recept;
import jr.springframework.repositories.ReceptRepository;
import jr.springframework.services.ReceptService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class IndexControllerTest {

    @Mock
    private ReceptService receptService;

    @InjectMocks
    private IndexController indexController;

    @Test
    public void testGeefIndexPaginaTerug() {
        // Prepare
        final Model model = Mockito.mock(Model.class);
        final List<Recept> testRecepten = new ArrayList<>();
        testRecepten.add(new Recept());
        final Recept testRecept = new Recept();
        testRecept.setId(5L);
        testRecepten.add(testRecept);
        final ArgumentCaptor<List<Recept>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        Mockito.when(receptService.krijgAlleRecepten()).thenReturn(testRecepten);
        // Execute
        final String resultaat = indexController.geefIndexPaginaTerug(model);
        // Verify
        Mockito.verify(receptService).krijgAlleRecepten();
        Mockito.verify(model).addAttribute(Mockito.eq("recepten"), argumentCaptor.capture());
        Assertions.assertThat(resultaat).isEqualTo("index");
        Assertions.assertThat(argumentCaptor.getValue()).hasSize(2);
    }
}

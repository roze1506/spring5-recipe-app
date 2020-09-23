package jr.springframework.controllers;

import jr.springframework.domain.Recept;
import jr.springframework.repositories.ReceptRepository;
import jr.springframework.services.ReceptService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
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
        Mockito.when(receptService.krijgAlleRecepten()).thenReturn(testRecepten);
        // Execute
        final String resultaat = indexController.geefIndexPaginaTerug(model);
        // Verify
        Mockito.verify(receptService).krijgAlleRecepten();
        Mockito.verify(model).addAttribute("recepten", testRecepten);
        Assertions.assertThat(resultaat).isEqualTo("index");
    }
}

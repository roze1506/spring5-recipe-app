package jr.springframework.controllers;

import jr.springframework.domain.Recept;
import jr.springframework.services.ReceptService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ReceptControllerTest {

    @Mock
    private ReceptService receptService;

    @InjectMocks
    private ReceptController receptController;

    @Test
    public void testIndexPaginaRequest() throws Exception {
        final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(receptController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/recept/details/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/recept/details"));
    }

    @Test
    public void testGeefReceptOpIdPaginaTerug() {
        // Prepare
        final Long testId = 5L;
        final Model model = Mockito.mock(Model.class);
        final Recept testRecept = new Recept();
        testRecept.setId(testId);
        final ArgumentCaptor<Recept> argumentCaptor = ArgumentCaptor.forClass(Recept.class);
        Mockito.when(receptService.krijgRecept(testId)).thenReturn(testRecept);
        // Execute
        final String resultaat = receptController.geefReceptOpIdPaginaTerug(testId, model);
        // Verify
        Mockito.verify(receptService).krijgRecept(testId);
        Mockito.verify(model).addAttribute(Mockito.eq("recept"), argumentCaptor.capture());
        Assertions.assertThat(resultaat).isEqualTo("/recept/details");
        Assertions.assertThat(argumentCaptor.getValue()).isEqualTo(testRecept);
    }
}

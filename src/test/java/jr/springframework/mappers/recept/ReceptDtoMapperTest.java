package jr.springframework.mappers.recept;

import jr.springframework.domain.Categorie;
import jr.springframework.domain.Ingredient;
import jr.springframework.domain.Notitie;
import jr.springframework.domain.Recept;
import jr.springframework.dtos.CategorieDto;
import jr.springframework.dtos.IngredientDto;
import jr.springframework.dtos.NotitieDto;
import jr.springframework.dtos.ReceptDto;
import jr.springframework.enums.Moeilijkheidsgraad;
import jr.springframework.mappers.categorie.CategorieDtoMapper;
import jr.springframework.mappers.ingredient.IngredientDtoMapper;
import jr.springframework.mappers.notitie.NotitieDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReceptDtoMapperTest {

    @Mock
    private NotitieDtoMapper notitieDtoMapper;
    @Mock
    private IngredientDtoMapper ingredientDtoMapper;
    @Mock
    private CategorieDtoMapper categorieDtoMapper;
    @InjectMocks
    private ReceptDtoMapper receptDtoMapper;

    @Test
    public void testTransform() {
        // Prepare
        final Notitie notitie = Mockito.mock(Notitie.class);
        final NotitieDto notitieDto = Mockito.mock(NotitieDto.class);
        final Ingredient ingredient = Mockito.mock(Ingredient.class);
        final IngredientDto ingredientDto = Mockito.mock(IngredientDto.class);
        final Categorie categorie = Mockito.mock(Categorie.class);
        final CategorieDto categorieDto = Mockito.mock(CategorieDto.class);
        final Recept recept = new Recept();
        recept.setId(5L);
        recept.setKookTijd(5);
        recept.setPorties(7);
        recept.setOmschrijving("OMSCHRIJVING");
        recept.setBron("BRON");
        recept.setUrl("URL");
        recept.setAanwijzingen("AANWIJZINGEN");
        recept.setMoeilijkheidsgraad(Moeilijkheidsgraad.MOEILIJK);
        recept.addCategorie(categorie);
        recept.addIngredient(ingredient);
        recept.setNotitie(notitie);
        Mockito.when(notitieDtoMapper.transform(recept.getNotitie())).thenReturn(notitieDto);
        Mockito.when(ingredientDtoMapper.transform(ingredient)).thenReturn(ingredientDto);
        Mockito.when(categorieDtoMapper.transform(categorie)).thenReturn(categorieDto);
        // Execute
        final ReceptDto resultaat = receptDtoMapper.transform(recept);
        // Verify
        Assertions.assertThat(resultaat.getId()).isEqualTo(5L);
        Assertions.assertThat(resultaat.getKookTijd()).isEqualTo(5);
        Assertions.assertThat(resultaat.getPorties()).isEqualTo(7);
        Assertions.assertThat(resultaat.getOmschrijving()).isEqualTo("OMSCHRIJVING");
        Assertions.assertThat(resultaat.getBron()).isEqualTo("BRON");
        Assertions.assertThat(resultaat.getUrl()).isEqualTo("URL");
        Assertions.assertThat(resultaat.getAanwijzingen()).isEqualTo("AANWIJZINGEN");
        Assertions.assertThat(resultaat.getMoeilijkheidsgraad()).isEqualTo(Moeilijkheidsgraad.MOEILIJK.name());
        Assertions.assertThat(resultaat.getNotitie()).isEqualTo(notitieDto);
        Assertions.assertThat(resultaat.getCategorieen().get(0)).isEqualTo(categorieDto);
        Assertions.assertThat(resultaat.getIngredienten().get(0)).isEqualTo(ingredientDto);
    }
}
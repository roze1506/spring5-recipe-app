package jr.springframework.bootstrap;

import jr.springframework.domain.*;
import jr.springframework.enums.Moeilijkheidsgraad;
import jr.springframework.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class BootStrapData implements CommandLineRunner {

    private final CategorieRepository categorieRepository;
    private final IngredientRepository ingredientRepository;
    private final MaatEenheidRepository maatEenheidRepository;
    private final NotitieRepository notitieRepository;
    private final ReceptRepository receptRepository;

    @Override
    public void run(String... args) throws Exception {
        log.debug("Voor het definiëren van data.");
        final Recept noodlesMetKipRecept = new Recept();
        noodlesMetKipRecept.setOmschrijving("Sticky kipkluifjes met noodles");
        noodlesMetKipRecept.setKookTijd(25);
        noodlesMetKipRecept.setPorties(4);
        noodlesMetKipRecept.setBron("Jumbo");
        noodlesMetKipRecept.setUrl("https://www.jumbo.com/recepten/sticky-kipkluifjes-met-noodles-504727");
        noodlesMetKipRecept.setMoeilijkheidsgraad(Moeilijkheidsgraad.MAKKELIJK);
        receptRepository.save(noodlesMetKipRecept);
        log.debug("Noodles met Kip recept opgeslagen in de Recepten tabel!");
        final Notitie nmkNotitie = new Notitie();
        nmkNotitie.setTekst("Dit is super lekker!");
        nmkNotitie.setRecept(noodlesMetKipRecept);
        notitieRepository.save(nmkNotitie);
        noodlesMetKipRecept.setNotitie(nmkNotitie);
        log.debug("Notitie toegevoegd aan Noodles met Kip Recept!");
        this.initIngredienten(noodlesMetKipRecept);
        noodlesMetKipRecept.setAanwijzingen("1) Verhit een wok zonder olie of boter en rooster de cashewnoten 3 min." +
                "Doe ze op een bord en laat afkoelen." +
                "Verhit 1 el zonnebloemolie in een koekenpan en bak de kip in 15 min. rondom gaar. \n" +
                "2) Kook intussen de noodles volgens de aanwijzingen op de verpakking. \n" +
                " Snijd de bosuitjes in ringetjes. Verhit 1 el zonnebloemolie in de wok en roerbak de groenten met twee derde van de bosui in 5 min. /n" +
                " beetgaar. Breng op smaak met 1 el teriyaki saus. \n" +
                "3) Voeg de rest van de saus toe aan de kip en laat 2 min. karamelliseren. Schep er de cashewnoten door en warm 1 min. mee. \n" +
                "4) Verdeel de noodles en groenten over 4 kommen. Schep er de kipkluifjes met de cashewnoten en saus op. \n" +
                " Garneer met de rest van de bosui.");
        log.debug("De aanwijzingen van hoe het Noodles met Kip recept klaargemaakt moet worden is toegevoegd!");
        final Categorie pasta = categorieRepository.findByAfdelingNaam("Pasta").get();
        categorieRepository.save(pasta);
        receptRepository.save(noodlesMetKipRecept);
        log.debug("Het Noodles met Kip Recept behoort tot de categorie Pasta!");
    }

    private void initIngredienten(Recept recept) {
        final MaatEenheid gram = maatEenheidRepository.findByEenheid("Gram").get();
        final MaatEenheid eetLepel = maatEenheidRepository.findByEenheid("Eetlepel").get();
        final MaatEenheid aantal = maatEenheidRepository.findByEenheid("Aantal").get();
        final MaatEenheid milliLiter = maatEenheidRepository.findByEenheid("MilliLiter").get();
        final Ingredient cashewNoten = new Ingredient("Ongezouten Cashewnoten",
                BigDecimal.valueOf(50), gram, recept);
        final Ingredient zonnebloemolie = new Ingredient("Zonnebloemolie",
                BigDecimal.valueOf(2), eetLepel, recept);
        final Ingredient scharrelkip = new Ingredient("Scharrelkip kluifjes",
                BigDecimal.valueOf(500), gram, recept);
        final Ingredient noodles = new Ingredient("Volkoren noodles",
                BigDecimal.valueOf(250), gram, recept);
        final Ingredient bosui = new Ingredient("Bosuitjes",
                BigDecimal.valueOf(1), aantal, recept);
        final Ingredient roerbakMix = new Ingredient("Thaise roerbakmix",
                BigDecimal.valueOf(800), gram, recept);
        final Ingredient teriyakiSaus = new Ingredient("Teriyaki saus",
                BigDecimal.valueOf(100), milliLiter, recept);
        ingredientRepository.save(cashewNoten);
        ingredientRepository.save(zonnebloemolie);
        ingredientRepository.save(scharrelkip);
        ingredientRepository.save(noodles);
        ingredientRepository.save(bosui);
        ingredientRepository.save(roerbakMix);
        ingredientRepository.save(teriyakiSaus);
        maatEenheidRepository.save(gram);
        maatEenheidRepository.save(eetLepel);
        maatEenheidRepository.save(aantal);
        maatEenheidRepository.save(milliLiter);
        receptRepository.save(recept);
        log.debug("Alle ingrediënten en bijbehorende maateenheden zijn toegekend aan het Noodles met Kip Recept!");
    }
}

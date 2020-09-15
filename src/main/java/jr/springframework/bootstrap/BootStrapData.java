package jr.springframework.bootstrap;

import jr.springframework.domain.*;
import jr.springframework.enums.Moeilijkheidsgraad;
import jr.springframework.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CategorieRepository categorieRepository;
    private final IngredientRepository ingredientRepository;
    private final MaatEenheidRepository maatEenheidRepository;
    private final NotitieRepository notitieRepository;
    private final ReceptRepository receptRepository;

    public BootStrapData(CategorieRepository categorieRepository, IngredientRepository ingredientRepository,
                         MaatEenheidRepository maatEenheidRepository, NotitieRepository notitieRepository,
                         ReceptRepository receptRepository) {
        this.categorieRepository = categorieRepository;
        this.ingredientRepository = ingredientRepository;
        this.maatEenheidRepository = maatEenheidRepository;
        this.notitieRepository = notitieRepository;
        this.receptRepository = receptRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        final Recept noodlesMetKipRecept = new Recept();
        noodlesMetKipRecept.setOmschrijving("Sticky kipkluifjes met noodles");
        noodlesMetKipRecept.setKookTijd(25);
        noodlesMetKipRecept.setPorties(4);
        noodlesMetKipRecept.setBron("Jumbo");
        noodlesMetKipRecept.setUrl("https://www.jumbo.com/recepten/sticky-kipkluifjes-met-noodles-504727");
        noodlesMetKipRecept.setMoeilijkheidsgraad(Moeilijkheidsgraad.MAKKELIJK);
        receptRepository.save(noodlesMetKipRecept);
        final Notitie nmkNotitie = new Notitie();
        nmkNotitie.setTekst("Dit is super lekker!");
        nmkNotitie.setRecept(noodlesMetKipRecept);
        notitieRepository.save(nmkNotitie);
        noodlesMetKipRecept.setNotitie(nmkNotitie);
        this.initIngredienten(noodlesMetKipRecept);
        noodlesMetKipRecept.setAanwijzingen("1) First this. \n" +
                "2) Then that. \n" +
                "3) Finally add this. \n" +
                "4) Enjoy! :)");
        final Categorie pasta = categorieRepository.findByAfdelingNaam("Pasta").get();
        categorieRepository.save(pasta);
        receptRepository.save(noodlesMetKipRecept);
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
    }
}

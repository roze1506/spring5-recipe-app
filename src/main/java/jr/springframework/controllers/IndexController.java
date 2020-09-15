package jr.springframework.controllers;

import jr.springframework.domain.Categorie;
import jr.springframework.domain.MaatEenheid;
import jr.springframework.repositories.CategorieRepository;
import jr.springframework.repositories.MaatEenheidRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategorieRepository categorieRepository;
    private MaatEenheidRepository maatEenheidRepository;

    public IndexController(CategorieRepository categorieRepository, MaatEenheidRepository maatEenheidRepository) {
        this.categorieRepository = categorieRepository;
        this.maatEenheidRepository = maatEenheidRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String geefIndexPaginaTerug() {
        final Optional<Categorie> categorieOptional = categorieRepository.findByAfdelingNaam("Pasta");
        final Optional<MaatEenheid> maatEenheidOptional = maatEenheidRepository.findByEenheid("Gram");
        if(categorieOptional.isPresent() && maatEenheidOptional.isPresent()) {
            System.out.println("ID van Categorie 'Pasta': " + categorieOptional.get().getId());
            System.out.println("ID van MaatEenheid 'Gram': " + maatEenheidOptional.get().getId());
        }
        return "index";
    }
}

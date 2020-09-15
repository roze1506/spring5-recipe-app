package jr.springframework.controllers;

import jr.springframework.domain.Categorie;
import jr.springframework.domain.MaatEenheid;
import jr.springframework.repositories.CategorieRepository;
import jr.springframework.repositories.MaatEenheidRepository;
import jr.springframework.repositories.ReceptRepository;
import jr.springframework.services.ReceptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final ReceptRepository receptRepository;
    private final ReceptService receptService;

    public IndexController(ReceptRepository receptRepository, ReceptService receptService) {
        this.receptRepository = receptRepository;
        this.receptService = receptService;
    }

    @RequestMapping({"", "/", "/index"})
    public String geefIndexPaginaTerug(Model model) {
        model.addAttribute("recepten", receptService.krijgAlleRecepten());
        return "index";
    }
}

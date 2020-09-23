package jr.springframework.controllers;

import jr.springframework.services.ReceptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final ReceptService receptService;

    public IndexController(ReceptService receptService) {
        this.receptService = receptService;
    }

    @RequestMapping({"", "/", "/index"})
    public String geefIndexPaginaTerug(Model model) {
        model.addAttribute("recepten", receptService.krijgAlleRecepten());
        return "index";
    }
}

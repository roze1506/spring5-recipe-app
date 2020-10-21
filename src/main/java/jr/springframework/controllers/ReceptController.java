package jr.springframework.controllers;

import jr.springframework.services.ReceptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class ReceptController {

    private final ReceptService receptService;

    @RequestMapping("/recept/details/{id}")
    public String geefReceptOpIdPaginaTerug(@PathVariable Long id, Model model) {
        model.addAttribute("recept", receptService.krijgRecept(id));
        return "/recept/details";
    }
}

package jr.springframework.mappers.categorie;

import jr.springframework.domain.Categorie;
import jr.springframework.dtos.CategorieDto;
import jr.springframework.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategorieDomainMapper {

    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie transformNieuweCategorie(CategorieDto categorieDto) {
        final Categorie categorie = new Categorie();
        categorie.setAfdelingNaam(categorieDto.getAfdelingNaam());
        return categorie;
    }

    public Categorie transformBestaandeCategorie(Long id, CategorieDto categorieDto) {
        final Categorie categorie = categorieRepository.findById(id).get();
        categorie.setAfdelingNaam(categorieDto.getAfdelingNaam());
        return categorie;
    }
}

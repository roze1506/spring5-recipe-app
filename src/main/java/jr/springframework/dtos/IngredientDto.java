package jr.springframework.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IngredientDto {

    private Long id;

    private String beschrijving;

    private BigDecimal aantal;

    private MaatEenheidDto maatEenheid;

    private ReceptDto recept;
}

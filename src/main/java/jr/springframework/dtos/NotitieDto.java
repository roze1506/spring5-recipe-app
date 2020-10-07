package jr.springframework.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotitieDto {

    private Long id;

    private String tekst;

    private ReceptDto recept;
}

package jr.springframework.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class CategorieDto {

    private Long id;

    private String afdelingNaam;

    private List<ReceptDto> recepten = new ArrayList<>();

    public List<ReceptDto> getRecepten() {
        return Collections.unmodifiableList(recepten);
    }

    public void addRecept(ReceptDto receptDto) {
        recepten.add(receptDto);
    }
}

package jr.springframework.mappers.notitie;

import jr.springframework.repositories.NotitieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class NotitieDomainMapperTest {

    @Mock
    private NotitieRepository notitieRepository;
    @InjectMocks
    private NotitieDomainMapper notitieDomainMapper;

    @Test
    public void testTransformNieuweNotitie() {
        // Prepare

        // Execute

        // Verify

    }

    @Test
    public void testTransformBestaandeNotitie() {
        // Prepare

        // Execute

        // Verify

    }

}
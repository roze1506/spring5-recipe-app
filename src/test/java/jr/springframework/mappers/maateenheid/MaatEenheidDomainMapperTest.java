package jr.springframework.mappers.maateenheid;

import jr.springframework.repositories.MaatEenheidRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaatEenheidDomainMapperTest {

    @Mock
    private MaatEenheidRepository maatEenheidRepository;
    @InjectMocks
    private MaatEenheidDomainMapper maatEenheidDomainMapper;

    @Test
    public void testTransformNieuweMaatEenheid() {
        // Prepare

        // Execute

        // Verify

    }

    @Test
    public void testTransformBestaandeMaatEenheid() {
        // Prepare

        // Execute

        // Verify

    }
}
package uk.oakwoodland.msscbreweryclient.web.client.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;
import uk.oakwoodland.msscbreweryclient.web.model.BeerDto;

@ActiveProfiles("snake")
@JsonTest // Spring managed
public class BeerDtoSnakeTest extends BaseTest {

    @Autowired // default Jackson Spring implementation
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }
}

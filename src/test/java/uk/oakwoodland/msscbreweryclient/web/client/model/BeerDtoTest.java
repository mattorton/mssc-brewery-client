package uk.oakwoodland.msscbreweryclient.web.client.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import uk.oakwoodland.msscbreweryclient.web.model.BeerDto;

@JsonTest // Spring managed
public class BeerDtoTest extends BaseTest {

    @Autowired // default Jackson Spring implementation
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserializeDto() throws JsonProcessingException {

        String jsonBeerDto = "{\"beerName\":\"Zoomer Ale\",\"beerStyle\":\"Ale\",\"upc\":1234567890,\"price\":\"10.99\",\"localDate\":\"20200504\",\"beerId\":\"ae5d6f26-37b3-417a-8620-1dcae05e9439\"}";

        BeerDto beerDto = objectMapper.readValue(jsonBeerDto, BeerDto.class);

        System.out.println(beerDto);
    }

}

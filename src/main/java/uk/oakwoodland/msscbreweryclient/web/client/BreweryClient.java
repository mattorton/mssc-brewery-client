package uk.oakwoodland.msscbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.oakwoodland.msscbreweryclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "owl.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        // map the BeerDto from the REST URI
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 +  uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){

        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);

    }

    public void updateBeer(UUID uuid, BeerDto beerDto){

        restTemplate.put(apiHost + BEER_PATH_V1 + uuid.toString(), beerDto);

    }

    public void deleteBeer(UUID uuid){

        restTemplate.delete(apiHost + BEER_PATH_V1 + uuid);

    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}

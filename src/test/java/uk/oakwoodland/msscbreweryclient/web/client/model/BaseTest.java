package uk.oakwoodland.msscbreweryclient.web.client.model;

import uk.oakwoodland.msscbreweryclient.web.model.BeerDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class BaseTest {

    BeerDto getBeerDto(){
        return BeerDto.builder()
                .beerName("Zoomer Ale")
                .beerStyle("Ale")
                .upc(1234567890L)
                .id(UUID.randomUUID())
                .price(BigDecimal.valueOf(10.99))
                .localDate(LocalDate.now())
                .build();
    }

}

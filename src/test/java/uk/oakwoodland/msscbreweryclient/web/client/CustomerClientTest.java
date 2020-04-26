package uk.oakwoodland.msscbreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.oakwoodland.msscbreweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomer() {
        CustomerDto customerDto = customerClient.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {

        CustomerDto customerDto = CustomerDto.builder()
                .name("Matthew")
                .build();

        URI uri = customerClient.saveNewCustomer(customerDto);

        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {

        CustomerDto customerDto = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Matthew")
                .build();

        customerClient.updateCustomer(customerDto.getId(), customerDto);
    }

    @Test
    void deleteCustomer() {

        customerClient.deleteCustomer(UUID.randomUUID());
    }
}
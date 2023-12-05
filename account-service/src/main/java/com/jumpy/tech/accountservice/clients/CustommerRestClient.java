package com.jumpy.tech.accountservice.clients;

import com.jumpy.tech.accountservice.model.Custommer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMMER-SERVICE")
public interface CustommerRestClient {
    @GetMapping("/custommers/{id}")
    @CircuitBreaker(name="customerService",fallbackMethod="getDefaultCustommer")
    Custommer findCustommerById(@PathVariable long id);
    @GetMapping("/custommers")
    @CircuitBreaker(name="customerService",fallbackMethod = "getAllCustomer")
    List<Custommer> allCustommers();
    default Custommer getDefaultCustommer(Long id, Exception ex){
        Custommer cust= new Custommer();
        cust.setId(id);
        cust.setFirstname("Not Available");
        cust.setLastname("Not Available");
        cust.setEmail("Not Available");
        return cust;
    }
    default List<Custommer> getAllCustomer(Exception e){
        return List.of();
    }

}

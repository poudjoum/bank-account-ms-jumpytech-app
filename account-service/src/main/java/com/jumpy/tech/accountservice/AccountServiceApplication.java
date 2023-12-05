package com.jumpy.tech.accountservice;

import com.jumpy.tech.accountservice.clients.CustommerRestClient;
import com.jumpy.tech.accountservice.entities.BankAccount;
import com.jumpy.tech.accountservice.enums.AccountType;
import com.jumpy.tech.accountservice.repository.BankAcountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAcountRepository acountRepository, CustommerRestClient restClient) {

        return args -> {
            restClient.allCustommers().forEach(c->{
                BankAccount bankAccount1= BankAccount.builder()
                        .AccountId(UUID.randomUUID().toString())
                        .currency("FCFA")
                        .balance(Math.random()*50000)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .custommerId(c.getId())
                        .build();
                BankAccount bankAccount2= BankAccount.builder()
                        .AccountId(UUID.randomUUID().toString())
                        .currency("FCFA")
                        .balance(Math.random()*75000)
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .custommerId(c.getId())
                        .build();
                acountRepository.save(bankAccount1);
                acountRepository.save(bankAccount2);
            });

        };
    }
}

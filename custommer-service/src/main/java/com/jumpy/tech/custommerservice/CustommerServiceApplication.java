package com.jumpy.tech.custommerservice;

import com.jumpy.tech.custommerservice.config.GlobalConfig;
import com.jumpy.tech.custommerservice.repository.CustommerRepository;
import com.jumpy.tech.custommerservice.entities.Custommer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustommerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustommerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandeLineRunner(CustommerRepository custoRepo){
        return args -> {
            List<Custommer>custommerList=List.of(
                  Custommer.builder()
                            .firstname("Gedeon Rodrigue")
                            .lastname("Poudjoum Leutcho")
                            .email("poudjoumr@gmail.com")
                            .build(),
                    Custommer.builder()
                            .firstname("Nathan Michee")
                            .lastname("Deumeni Leutcho")
                            .email("deumeni.leutcho@gmail.com")
                            .build()
            );
              custoRepo.saveAll(custommerList);

        };

    }

}

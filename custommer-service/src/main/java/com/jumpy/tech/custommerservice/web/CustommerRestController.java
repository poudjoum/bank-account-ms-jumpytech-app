package com.jumpy.tech.custommerservice.web;

import com.jumpy.tech.custommerservice.repository.CustommerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.jumpy.tech.custommerservice.entities.Custommer;

import java.util.List;

@RestController
public class CustommerRestController {
    private CustommerRepository custRepo;

    public CustommerRestController(CustommerRepository custRepo) {
        this.custRepo = custRepo;
    }
    @GetMapping("/custommers")
    public List<Custommer> custommerList(){

        return custRepo.findAll();
    }
    @GetMapping("/custommers/{id}")
    public Custommer custommerById(@PathVariable Long id){
        return custRepo.findById(id).get();
    }

}

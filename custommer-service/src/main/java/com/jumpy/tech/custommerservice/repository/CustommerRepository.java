package com.jumpy.tech.custommerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jumpy.tech.custommerservice.entities.Custommer;



public interface CustommerRepository extends JpaRepository<Custommer,Long>{
}

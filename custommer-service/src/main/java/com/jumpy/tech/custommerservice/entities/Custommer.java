package com.jumpy.tech.custommerservice.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Custommer {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    private String firstname;
    private String lastname;
    private String email;
}

package com.jumpy.tech.accountservice.entities;

import com.jumpy.tech.accountservice.enums.AccountType;
import com.jumpy.tech.accountservice.model.Custommer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    private String AccountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Custommer custommer;
    private Long custommerId;
}

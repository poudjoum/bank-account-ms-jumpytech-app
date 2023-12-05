package com.jumpy.tech.accountservice.repository;

import com.jumpy.tech.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface BankAcountRepository extends JpaRepository<BankAccount,String> {

}

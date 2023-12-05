package com.jumpy.tech.accountservice.web;

import com.jumpy.tech.accountservice.clients.CustommerRestClient;
import com.jumpy.tech.accountservice.entities.BankAccount;
import com.jumpy.tech.accountservice.model.Custommer;
import com.jumpy.tech.accountservice.repository.BankAcountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {
        private final BankAcountRepository bankAcountRepository;
        private final CustommerRestClient custommerRestClient;
        public BankAccountRestController(BankAcountRepository accountRepository,CustommerRestClient restClient){
            this.bankAcountRepository=accountRepository;
            this.custommerRestClient=restClient;
        }
        @GetMapping("/accounts")
        public List<BankAccount>accountList(){
            List<BankAccount>accountList=bankAcountRepository.findAll();
            accountList.forEach(acc->{
                acc.setCustommer(custommerRestClient.findCustommerById(acc.getCustommerId()));
            });
            return accountList;
        }
        @GetMapping("/accounts/{id}")
        public BankAccount bankAccountById(@PathVariable String id){
            BankAccount bankAccount=bankAcountRepository.findById(id).get();
            Custommer cust=custommerRestClient.findCustommerById(bankAccount.getCustommerId());
            bankAccount.setCustommer(cust);
            return bankAccount;
        }
}

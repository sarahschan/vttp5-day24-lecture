package sg.edu.nus.iss.paf_day24l.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_day24l.models.BankAccount;
import sg.edu.nus.iss.paf_day24l.services.BankAccountService;

@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountRestController {
    
    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("/exists/{account-id}")
    public ResponseEntity<Boolean> checkAccountExists(@PathVariable("account-id") int accountId) {
        
        Boolean isAccountExists = bankAccountService.checkAccountExists(accountId);
        return ResponseEntity.ok().body(isAccountExists);
        
    }


    @GetMapping("/{account-id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable("account-id") int accountId){
        
        BankAccount bankAccount = bankAccountService.getAccountById(accountId);
        return ResponseEntity.ok().body(bankAccount);
    }
    
}

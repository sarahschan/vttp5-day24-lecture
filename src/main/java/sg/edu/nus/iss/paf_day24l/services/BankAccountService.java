package sg.edu.nus.iss.paf_day24l.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day24l.repositories.BankAccountRepository;

@Service
public class BankAccountService {
    
    @Autowired
    BankAccountRepository bankAccountRepository;

    public Boolean checkAccountExists(int accountId) {
        return bankAccountRepository.accountExists(accountId);
    }
}

package sg.edu.nus.iss.paf_day24l.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.paf_day24l.models.BankAccount;
import sg.edu.nus.iss.paf_day24l.models.exceptions.AccountInactiveException;
import sg.edu.nus.iss.paf_day24l.models.exceptions.InsufficientBalanceException;
import sg.edu.nus.iss.paf_day24l.repositories.BankAccountRepository;

@Service
public class BankAccountService {
    
    @Autowired
    BankAccountRepository bankAccountRepository;

    public Boolean checkAccountExists(int accountId) {
        return bankAccountRepository.accountExists(accountId);
    }


    public BankAccount getAccountById(int accountId) {
        return bankAccountRepository.getAccountById(accountId);
    }


    public Boolean checkAccountActive(BankAccount bankAccount) {
        if (bankAccount.getIsActive().equals(true)){
            return true;
        }

        throw new AccountInactiveException(String.format("Account ID %d - %s is inactive", bankAccount.getId(), bankAccount.getFullName()));
    }


    public Boolean checkSufficientBalance(BankAccount bankAccount, float transferAmount) {
        Boolean sufficientBalance = (bankAccount.getBalance() - transferAmount >= 0) ? true : false;

        if (sufficientBalance){
            return true;
        }

        throw new InsufficientBalanceException(String.format("Transferer %s does not have enough funds to transfer $%f", bankAccount.getFullName(), transferAmount));
    }


    @Transactional
    public boolean transfer(int transferedAcountId, int transfereeAccountId, float transferAmount) {
        
        // retrieve two accounts
        BankAccount fromAccount = getAccountById(transferedAcountId);
        BankAccount toAccount = getAccountById(transfereeAccountId);

        // check both accounts active or not
        Boolean isAccountFromActive = checkAccountActive(fromAccount);
        Boolean isAccountToActive = checkAccountActive(toAccount);

        // check transfered has sufficient account balance
        Boolean isTransferrerBalanceSufficient = checkSufficientBalance(fromAccount, transferAmount);

        if (isAccountFromActive && isAccountToActive && isTransferrerBalanceSufficient) {
            fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
            bankAccountRepository.setAccountBalance(fromAccount);

            toAccount.setBalance(toAccount.getBalance() + transferAmount);
            bankAccountRepository.setAccountBalance(toAccount);

            return true;
        }

        return false;

    }


    public Boolean createNewAccount(String accountName, Boolean isActive, float amount) {
        return bankAccountRepository.createNewAccount(accountName, isActive, amount);
    }
    
}

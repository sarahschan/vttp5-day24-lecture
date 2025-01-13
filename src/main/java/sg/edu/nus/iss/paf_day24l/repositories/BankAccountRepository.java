package sg.edu.nus.iss.paf_day24l.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day24l.models.BankAccount;
import sg.edu.nus.iss.paf_day24l.models.exceptions.AccountNotFoundException;
import sg.edu.nus.iss.paf_day24l.models.exceptions.UnableToCreateAccountException;
import sg.edu.nus.iss.paf_day24l.utils.Query;

@Repository
public class BankAccountRepository {
    
    @Autowired
    JdbcTemplate template;


    public boolean accountExists(int accountId) {
        
        // // Method 1
        // Integer count = template.queryForObject(Query.SQL_CHECK_ACCOUNT_EXISTS, Integer.class, accountId);
        // return count != null && count > 0;


        // Method 2
        try {
            BankAccount bankAccount = template.queryForObject(Query.SQL_SELECT_ACCOUNT_BY_ID, BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);
            return true;

        } catch (DataAccessException error) {
            throw new AccountNotFoundException("The account you are querying does not exist in the database");
        }

    }


    public BankAccount getAccountById(int accountId) {

        try {
            
            BankAccount foundAccount = template.queryForObject(Query.SQL_SELECT_ACCOUNT_BY_ID, BeanPropertyRowMapper.newInstance(BankAccount.class), accountId);
            return foundAccount;

        } catch (DataAccessException ex) {
            throw new AccountNotFoundException(String.format("The account with id %d does not exist", accountId));

        }
    }


    public Boolean setAccountBalance(BankAccount accountUpdatedValues) {
        int accountUpdated = template.update(Query.SQL_SET_BALANCE_BY_ID, accountUpdatedValues.getBalance(), accountUpdatedValues.getId());

        if (accountUpdated == 1) {
            return true;
        } else {
            return false;
        }
    }


    public Boolean createNewAccount(String accountName, Boolean isActive, float amount) {

        try {
            template.update(Query.SQL_CREATE_ACCOUNT, accountName, isActive, amount);
            return true;

        } catch (DataAccessException ex) {
            throw new UnableToCreateAccountException("Unable to create new account");
        }

    }

}

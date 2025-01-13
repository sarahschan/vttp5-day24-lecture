package sg.edu.nus.iss.paf_day24l.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day24l.models.BankAccount;
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

            return false;
        }

    }
}

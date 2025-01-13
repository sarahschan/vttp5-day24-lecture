package sg.edu.nus.iss.paf_day24l.utils;

public class Query {
    
    public static final String SQL_CREATE_ACCOUNT = 
        """
            insert into BankAccount
                (fullName, isActive, balance)
            values
                (?, ?, ?)
        """;


    public static final String SQL_SELECT_ALL_FROM_BANKACCOUNT = 
        """
            select * from BankAccount        
        """;

    
    public static final String SQL_SELECT_ACCOUNT_BY_ID = 
        """
            select * from BankAccount 
                where id = ?        
        """;


    public static final String SQL_SET_INACTIVE_BY_ID = 
        """
            update BankAccount 
                set isActive = false 
                where id = ?     
        """;

    
    public static final String SQL_SET_BALANCE_BY_ID = 
        """
            update BankAccount 
                set balance = ?
                where id = ?        
        """;


    public static final String SQL_CHECK_ACCOUNT_EXISTS = 
        """
            select count(*) as count
                from BankAccount
                where id = ?
        """;


    public static final String SQL_CREATE_BOOK = 
        """
            insert into book
                (title, quantity, is_active)
            values
                (?, ?, ?)    
        """;


    public static final String SQL_GET_ALL_BOOKS = 
        """
            select * from book        
        """;


    public static final String SQL_GET_BOOK_BY_ID = 
        """
            select * from book     
                where id = ?   
        """;


    public static final String SQL_UPDATE_BOOK_BY_ID = 
        """
            update book
                set title = ?, quantity = ?
                where id = ?
        """;

    
    public static final String SQL_UPDATE_BOOK_STATUS_BY_ID = 
        """
            update book
                set is_active = ?
                where id = ?
        """;

    
    public static final String SQL_GET_ALL_RESERVATIONS =
        """
            select * from reservation        
        """;


    public static final String SQL_CREATE_RESERVATION = 
        """
            insert into reservation
                (full_name, reservation_date)    
            values
                (?, ?)
        """;


    public static final String SQL_INSERT_RESERVATION_DETAIL = 
        """
            insert into reservationdetail
                (book_id, reservation_id)
            values
                (?, ?)        
        """;
}

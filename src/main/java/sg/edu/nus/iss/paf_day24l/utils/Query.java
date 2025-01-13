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


    public static final String SQL_CREATE_BOOKING = 
        """
            insert into booking
                (title, quantity)
            values
                (?, ?)    
        """;


    public static final String SQL_GET_ALL_BOOKINGS = 
        """
            select * from booking        
        """;


    public static final String SQL_GET_BOOKING_BY_ID = 
        """
            select * from booking     
                where id = ?   
        """;


    public static final String SQL_UPDATE_BOOK_BY_ID = 
        """
            update booking
                set title = ?, quantity = ?
                where id = ?
        """;

    
    public static final String SQL_UPDATE_BOOK_STATUS_BY_ID = 
        """
            update booking
                set is_active = ?
                where id = ?
        """;
}

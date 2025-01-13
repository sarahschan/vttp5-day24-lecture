package sg.edu.nus.iss.paf_day24l.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day24l.models.Book;
import sg.edu.nus.iss.paf_day24l.utils.Query;

@Repository
public class BookRepository {
    
    @Autowired
    JdbcTemplate template;


    public Boolean insertBook(Book book) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(Query.SQL_CREATE_BOOK, new String[] {"id"});
                ps.setString(1, book.getTitle());
                ps.setInt(2, book.getQuantity());

                return ps;
            }
        };

        int createdBookId = template.update(psc, keyHolder);

        if (createdBookId > 0) {
            return true;
        }

        return false;
    }


    public List<Book> getAllBooks() {
        
        List<Book> bookings = template.query(Query.SQL_GET_ALL_BOOKS, BeanPropertyRowMapper.newInstance(Book.class));
        return bookings;
    }


    public Book getBookById(int bookId) {
        
        Book foundBooking = template.queryForObject(Query.SQL_GET_BOOK_BY_ID, BeanPropertyRowMapper.newInstance(Book.class), bookId);
        return foundBooking;
    }


    public Boolean updateBook(Book updatedBook) {
        
        int updateSuccessful = template.update(Query.SQL_UPDATE_BOOK_BY_ID, updatedBook.getTitle(), updatedBook.getQuantity(), updatedBook.getId());
        
        if (updateSuccessful > 0) {
            return true;
        }

        return false;
    }


    public Boolean updateBookStatus(Book updatedBook) {
        int updateSuccessful = template.update(Query.SQL_UPDATE_BOOK_STATUS_BY_ID, updatedBook.getIsActive(), updatedBook.getId());

        if (updateSuccessful > 0) {
            return true;
        }

        return false;
    }
}

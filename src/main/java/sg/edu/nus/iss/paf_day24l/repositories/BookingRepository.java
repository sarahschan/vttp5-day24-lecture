package sg.edu.nus.iss.paf_day24l.repositories;

import java.beans.BeanProperty;
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
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day24l.models.Booking;
import sg.edu.nus.iss.paf_day24l.utils.Query;

@Repository
public class BookingRepository {
    
    @Autowired
    JdbcTemplate template;


    public Boolean insertBook(Booking booking) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(Query.SQL_CREATE_BOOKING, new String[] {"id"});
                ps.setString(1, booking.getTitle());
                ps.setInt(2, booking.getQuantity());

                return ps;
            }
        };

        int createdBookingId = template.update(psc, keyHolder);

        if (createdBookingId > 0) {
            return true;
        }

        return false;
    }


    public List<Booking> getAllBookings() {
        
        List<Booking> bookings = template.query(Query.SQL_GET_ALL_BOOKINGS, BeanPropertyRowMapper.newInstance(Booking.class));
        return bookings;
    }


    public Booking getBookingById(int bookingId) {
        
        Booking foundBooking = template.queryForObject(Query.SQL_GET_BOOKING_BY_ID, BeanPropertyRowMapper.newInstance(Booking.class), bookingId);
        return foundBooking;
    }


    public Boolean updateBooking(Booking updatedBooking) {
        
        int updateSuccessful = template.update(Query.SQL_UPDATE_BOOK_BY_ID, updatedBooking.getTitle(), updatedBooking.getQuantity(), updatedBooking.getId());
        
        if (updateSuccessful > 0) {
            return true;
        }

        return false;
    }


    public Boolean updateBookStatus(Booking updatedBooking) {
        int updateSuccessful = template.update(Query.SQL_UPDATE_BOOK_STATUS_BY_ID, updatedBooking.getIsActive(), updatedBooking.getId());

        if (updateSuccessful > 0) {
            return true;
        }

        return false;
    }
}

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

import sg.edu.nus.iss.paf_day24l.models.Reservation;
import sg.edu.nus.iss.paf_day24l.models.ReservationDetail;
import sg.edu.nus.iss.paf_day24l.utils.Query;

@Repository
public class ReservationRepository {
    
    @Autowired
    JdbcTemplate template;


    public List<Reservation> getAllReservations(){
        List<Reservation> reservations = template.query(Query.SQL_GET_ALL_RESERVATIONS, BeanPropertyRowMapper.newInstance(Reservation.class));
        return reservations;
    }
    

    public int createReservation(Reservation reservation) {
                
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(Query.SQL_CREATE_RESERVATION, new String[] {"id"});
                ps.setString(1, reservation.getFullName());
                ps.setDate(2, reservation.getReservationDate());

                return ps;
            }

        };

        template.update(psc, keyHolder);

        int reservationId = keyHolder.getKey().intValue();

        return reservationId;
    }


    public boolean createReservationDetails(ReservationDetail reservationDetail) {
        int reservationDetailId = template.update(Query.SQL_INSERT_RESERVATION_DETAIL, reservationDetail.getBook().getId(), reservationDetail.getReservation().getId());

        if (reservationDetailId > 0) {
            return true;
        }

        return false;
    }
}

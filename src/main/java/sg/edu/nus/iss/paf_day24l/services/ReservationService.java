package sg.edu.nus.iss.paf_day24l.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.paf_day24l.models.Reservation;
import sg.edu.nus.iss.paf_day24l.models.ReservationDetail;
import sg.edu.nus.iss.paf_day24l.repositories.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    ReservationRepository reservationRepository;


    public List<Reservation> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    @Transactional
    public boolean createReservationRecord(Reservation reservation, ReservationDetail reservationDetail) {
        
        Boolean isCreated = false;

        int iReservationId = reservationRepository.createReservation(reservation);

        System.out.println(iReservationId);

        // uncomment to simulate error
        // throw new IllegalArgumentException("simulate error after creating reservation");

        reservationDetail.getReservation().setId(iReservationId);
        reservationRepository.createReservationDetails(reservationDetail);

        // uncomment to simulate error
        // throw new IllegalArgumentException("simulate error after creating reservation");

        isCreated = true;

        return isCreated;

    }
}

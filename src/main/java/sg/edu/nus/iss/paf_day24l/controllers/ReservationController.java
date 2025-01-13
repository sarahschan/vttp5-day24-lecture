package sg.edu.nus.iss.paf_day24l.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_day24l.models.Reservation;
import sg.edu.nus.iss.paf_day24l.models.ReservationDetail;
import sg.edu.nus.iss.paf_day24l.services.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    
    @Autowired
    ReservationService reservationService;


    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok().body(reservations);
    }


    @PostMapping("/new")
    public ResponseEntity<Boolean> createNewReservation(@RequestBody ReservationDetail reservationDetail){
        Boolean reservationDetailCreated = reservationService.createReservationRecord(reservationDetail.getReservation(), reservationDetail);

        return ResponseEntity.ok().body(reservationDetailCreated);
    }
}

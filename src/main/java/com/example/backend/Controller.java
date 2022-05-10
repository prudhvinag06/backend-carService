package com.example.backend;

import com.example.backend.DAO.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")

public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);

    @Autowired
    private DetailsJpaRepository detailsJpaRepository;

    @Autowired
    private ServiceJpaRepository serviceJpaRepository;

    @Autowired
    private SubServiceJpaRepository subServiceJpaRepository;
    @Autowired
    private BookServiceJpaRepository bookServiceJpaRepository;

    @PostMapping("/users/register/")
    public Long addUser(@RequestBody UserDetails details){
        logger.info("[REGISTER]");
        UserDetails details1 = detailsJpaRepository.save(details);
        //return id of user and use that to get current bookings etc
        return details.getUser_id();
    }

    @PostMapping("/admin/registerService/")
    public Long addService(@RequestBody Service service){
        logger.info("[ADD SERVICE]");

        Service service1 = serviceJpaRepository.save(service);
        return service1.getId();
    }

    @PostMapping("/admin/registerService/registerSubService")
    public Long addSubService(@RequestBody SubServiceDetails subServiceDetails){
        logger.info("[SUB SERVICE]");

        SubServiceDetails subServiceDetails1 = subServiceJpaRepository.save(subServiceDetails);
        return subServiceDetails1.getId();
    }

    @GetMapping("/users/services/getAllServices")
    public List<Service> getAllServices(){
        logger.info("[GET SERVICES]");
        return serviceJpaRepository.findAll();
    }

    @GetMapping("/users/services/getSubServices/{serviceProviderID}")
    public List<SubServiceDetails> getSubServices(@PathVariable Long serviceProviderID) {
        logger.info("[SUB SERVICES]");
        return subServiceJpaRepository.findByServiceProviderID(serviceProviderID);
    }

    @GetMapping("/users/logincheck/{email}/{password}")
    public boolean getSubServices(@PathVariable String email, @PathVariable String password) {
        logger.info("[GET SUB SERVICE]");
        UserDetails details = detailsJpaRepository.findUserDetailsByEmailAndPassword(email, password);
        if(details == null)
            return false;
        else return true;
    }

    @GetMapping("/users/getIdFromUsername/{email}")
    public Long getIdFromUserName(@PathVariable String email){
        logger.info("[GET ID FROM USERNAME]");
        UserDetails details = detailsJpaRepository.findByEmail(email);
        return details.getUser_id();
    }

    @GetMapping("/users/services/getAllServicesWithLocation/{location}")
    public List<Service> getAllServicesWithLocation(@PathVariable String location) {
        logger.info("[GET ALL SERVICES WITH LOCATION]");
        List<Service> serviceWithLocation = serviceJpaRepository.findByLocation(location);
        return serviceWithLocation;
    }

    @PostMapping("users/services/bookService")
    public Long addBookingDetails(@RequestBody BookingsDetails bookingsDetails ){
        logger.info("[ADDED BOOKING DETAILS]");
        BookingsDetails bookingsDetails1 = bookServiceJpaRepository.save(bookingsDetails);
        return bookingsDetails1.getBooking_id();
    }

    @GetMapping("users/bookings/{user_id}")
    public List<BookingsDetails> getCurrentBookins(@PathVariable Long user_id){
        logger.info("[GET ALL CURRENT BOOKINGS]");
        List<BookingsDetails> bookingsDetails1 = bookServiceJpaRepository.findByUser_Id(user_id);

        return bookingsDetails1;
    }

    @GetMapping("users/bookings")
    public List<BookingsDetails> getAllBookings(){
        logger.info("[GET ALL BOOKINGS]");
        List<BookingsDetails> bookingsDetails1 = bookServiceJpaRepository.findAllWithStatusIsTrue();
        return bookingsDetails1;
    }

    @PutMapping("users/bookings/completed/{bookingid}")
    public Long updateStatusService(@PathVariable Long bookingid){
        logger.info("[UPDATE SERVICE STATUS]");
        bookServiceJpaRepository.updateStatus(bookingid);
        return (long)1;
    }
}

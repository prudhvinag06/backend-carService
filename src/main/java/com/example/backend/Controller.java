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
        logger.info("[REGISTER]" + "Asdasd");
        UserDetails details1 = detailsJpaRepository.save(details);
        //return id of user and use that to get current bookings etc
        return details.getUser_id();
    }

    @PostMapping("/admin/registerService/")
    public Long addService(@RequestBody Service service){
        Service service1 = serviceJpaRepository.save(service);
        return service1.getId();
    }

    @PostMapping("/admin/registerService/registerSubService")
    public Long addSubService(@RequestBody SubServiceDetails subServiceDetails){
        SubServiceDetails subServiceDetails1 = subServiceJpaRepository.save(subServiceDetails);
        return subServiceDetails1.getId();
    }

    @GetMapping("/users/services/getAllServices")
    public List<Service> getAllServices(){
        return serviceJpaRepository.findAll();
    }

    @GetMapping("/users/services/getSubServices/{serviceProviderID}")
    public List<SubServiceDetails> getSubServices(@PathVariable Long serviceProviderID) {
        return subServiceJpaRepository.findByServiceProviderID(serviceProviderID);
    }

    @GetMapping("/users/logincheck/{email}/{password}")
    public boolean getSubServices(@PathVariable String email, @PathVariable String password) {
        UserDetails details = detailsJpaRepository.findUserDetailsByEmailAndPassword(email, password);
        if(details == null)
            return false;
        else return true;
    }

    @GetMapping("/users/getIdFromUsername/{email}")
    public Long getIdFromUserName(@PathVariable String email){
        UserDetails details = detailsJpaRepository.findByEmail(email);
        return details.getUser_id();
    }

    @GetMapping("/users/services/getAllServicesWithLocation/{location}")
    public List<Service> getAllServicesWithLocation(@PathVariable String location) {
        System.out.println("sss " + location);
        List<Service> serviceWithLocation = serviceJpaRepository.findByLocation(location);
        return serviceWithLocation;
    }

    @PostMapping("users/services/bookService")
    public Long addBookingDetails(@RequestBody BookingsDetails bookingsDetails ){
        BookingsDetails bookingsDetails1 = bookServiceJpaRepository.save(bookingsDetails);
        return bookingsDetails1.getBooking_id();
    }

    @GetMapping("users/bookings/{user_id}")
    public List<BookingsDetails> getCurrentBookins(@PathVariable Long user_id){
        List<BookingsDetails> bookingsDetails1 = bookServiceJpaRepository.findByUser_Id(user_id);

        return bookingsDetails1;
    }

    @GetMapping("users/bookings")
    public List<BookingsDetails> getAllBookings(){
        List<BookingsDetails> bookingsDetails1 = bookServiceJpaRepository.findAllWithStatusIsTrue();
        return bookingsDetails1;
    }

    @PutMapping("users/bookings/completed/{bookingid}")
    public Long updateStatusService(@PathVariable Long bookingid){
        bookServiceJpaRepository.updateStatus(bookingid);
        return (long)1;
    }
}

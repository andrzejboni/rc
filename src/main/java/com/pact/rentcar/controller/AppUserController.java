package com.pact.rentcar.controller;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Booking;
import com.pact.rentcar.service.AppUserAuthenticationService;
import com.pact.rentcar.service.AppUserService;
import com.pact.rentcar.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/user/")
public class AppUserController {

//    @GetMapping(path = "/profile") // 03/28:22
//    public String getProfile(){
//        return "user/profile";
//    }

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AppUserAuthenticationService appUserAuthenticationService;

    @Autowired
    AppUserService appUserService;

    @ModelAttribute("loggedIn")
    public boolean getIsLoggedIn() {
        return appUserAuthenticationService.getLoggedInUser().isPresent();
    }


//    @GetMapping(path = "/profile")
//    public String getAllUserBookings(Model model) {
//
//        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // pobieram ID zalogowanego użytkownika
//
//        List<Booking> bookingsList = bookingService.findAllByAppUserId(appUser.getId());
//
//        model.addAttribute("bookings", bookingsList);
//
//        return "user/profile";
//    }


    @GetMapping(path = "/profile")
    public String getAllBookings(Model model) {
        List<Booking> bookingsList = bookingService.findAllBookings();

        model.addAttribute("bookings", bookingsList);

        return "user/profile";
    }


}

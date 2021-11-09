package com.decagon.phila.controller;
import com.decagon.phila.payload.request.auth.EditUser;
import com.decagon.phila.payload.response.Response;
import com.decagon.phila.payload.response.auth.ResetPassword;
import com.decagon.phila.repository.RoleRepository;
import com.decagon.phila.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;


    @PutMapping("/profile")
    @Secured({"ADMIN","USER"})
    public ResponseEntity<?> editProfile(@Valid @RequestBody EditUser user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @PostMapping("/customer/password-forgot")
    @Secured("USER")
    public ResponseEntity<Response> userForgotPassword(@RequestParam("email") String accountEmail, HttpServletRequest request){
        return userService.userForgotPassword(request, accountEmail);
    }


    @PostMapping("/customer/password-reset")
    @Secured("USER")
    public ResponseEntity<Response> userResetPassword(@Valid @RequestBody ResetPassword resetPassword) {
        return userService.userResetPassword(resetPassword);
    }

    @GetMapping("/user-details")
    @Secured({"ADMIN", "USER"})
    public ResponseEntity<?>  getUserDetails(){
        return new ResponseEntity<>(userService.getUserDetails(), HttpStatus.OK);
    }

}
package com.social.media.controllers;

import com.social.media.models.SocialUser;
import com.social.media.services.SocialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {

    @Autowired
    private SocialServices socialServices;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers() {
        return new ResponseEntity<>(socialServices.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/social/user")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {
        return new ResponseEntity<>(socialServices.saveUser(socialUser), HttpStatus.CREATED);
    }

}

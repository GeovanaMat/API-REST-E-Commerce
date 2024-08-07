package com.geo.api_gerenciamento_ecommerce.controller;

import com.geo.api_gerenciamento_ecommerce.dtos.ProfileDto;
import com.geo.api_gerenciamento_ecommerce.model.ProfileModel;
import com.geo.api_gerenciamento_ecommerce.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<ProfileModel> creatProfile(@RequestBody ProfileDto profileDto){
        return new ResponseEntity<>(profileService.creatProfile(profileDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProfileModel>> getAllProfile(){
        return new ResponseEntity<>(profileService.getAllProfiles(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProfileModel> getOneProfile(@PathVariable(value = "id") Long id){
        return  new ResponseEntity<>(profileService.getProfileById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProfileModel> updateOneProfile(@PathVariable(value = "id") Long id, @RequestBody ProfileDto profileDto){
        return new ResponseEntity<>(profileService.updateProfileById(id,profileDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneProfile(@PathVariable(value = "id") Long id){
        return  new ResponseEntity<>("Profile id: " + id + " deleted sucessfuly", HttpStatus.OK);
    }
}


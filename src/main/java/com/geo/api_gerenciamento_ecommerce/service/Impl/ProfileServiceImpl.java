package com.geo.api_gerenciamento_ecommerce.service.Impl;

import com.geo.api_gerenciamento_ecommerce.dtos.ProfileDto;
import com.geo.api_gerenciamento_ecommerce.exception.ResourceAlreadyExistException;
import com.geo.api_gerenciamento_ecommerce.exception.ResourceNotFoundException;
import com.geo.api_gerenciamento_ecommerce.model.ProfileModel;
import com.geo.api_gerenciamento_ecommerce.repository.CustomerRepository;
import com.geo.api_gerenciamento_ecommerce.repository.ProfileRepository;
import com.geo.api_gerenciamento_ecommerce.service.CustomerService;
import com.geo.api_gerenciamento_ecommerce.service.ProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CustomerService customerService;


    @Override
    public ProfileModel creatProfile(ProfileDto profileDto) {
       var customerData = customerService.getCustomerById(profileDto.customerId());
       if(customerData.getProfile() == null) {
           var newProfile = new ProfileModel();
           BeanUtils.copyProperties(profileDto, newProfile);
           newProfile.setCustomer(customerData);
           profileRepository.save(newProfile);
           return newProfile;
       }
       throw new ResourceAlreadyExistException("Profile for this user already exists");
    }

    @Override
    public ProfileModel getProfileById(Long id) {
        var profileDataBase = profileRepository.findById(id);
        if(profileDataBase.isPresent()) {
            return profileDataBase.get();
        }
        throw new ResourceNotFoundException("Profile not found.");
    }

    @Override
    public List<ProfileModel> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public ProfileModel updateProfileById(Long id, ProfileDto profileDto) {
        var profileDataBase = getProfileById(id);
        BeanUtils.copyProperties(profileDto,profileDataBase);
        profileRepository.save(profileDataBase);
        return profileDataBase;
    }

    @Override
    public void deleteProfileById(Long id) {
        var profileDatabase = getProfileById(id);
        profileRepository.delete(profileDatabase);
    }
}

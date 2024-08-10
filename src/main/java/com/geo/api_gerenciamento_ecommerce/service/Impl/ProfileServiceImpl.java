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


    private final ProfileRepository profileRepository;

    private final CustomerRepository customerRepository;

    @Autowired
    public  ProfileServiceImpl(CustomerRepository customerRepository, ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Creates a new profile based on the provided profiletDto. Only create a profile if
     * costumer don't have a profile.
     *
     * @param profileDto the data transfer object containing profile details
     * @return the created ProfileModel
     * @throws ResourceNotFoundException if the costumer does not exist.
     * @throws ResourceAlreadyExistException if profile already exist in database.
     */

    @Override
    public ProfileModel creatProfile(ProfileDto profileDto) {
        var customerData = customerRepository.findById(profileDto.customerId());
        if(customerData.isPresent() && customerData.get().getProfile() == null) {
            var customer = customerData.get();
            var newProfile = new ProfileModel();
            BeanUtils.copyProperties(profileDto, newProfile);
            newProfile.setCustomer(customer);
            profileRepository.save(newProfile);

            // Atualiza o cliente com o novo perfil
            customer.setProfile(newProfile);
            customerRepository.save(customer);

            return newProfile;
        } else if (customerData.isEmpty()){
            throw new ResourceNotFoundException("Customer not found.");
        }
        throw new ResourceAlreadyExistException("Profile for this user already exists.");
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

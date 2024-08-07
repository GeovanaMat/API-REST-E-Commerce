package com.geo.api_gerenciamento_ecommerce.service;

import com.geo.api_gerenciamento_ecommerce.dtos.ProfileDto;
import com.geo.api_gerenciamento_ecommerce.model.ProfileModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {
    public ProfileModel creatProfile(ProfileDto profileDto);
    public ProfileModel getProfileById(Long id);
    public List<ProfileModel> getAllProfiles();
    public ProfileModel updateProfileById(Long id, ProfileDto profileDto);
    public void deleteProfileById(Long id);
}

package com.geo.api_gerenciamento_ecommerce.repository;

import com.geo.api_gerenciamento_ecommerce.model.CustomerModel;
import com.geo.api_gerenciamento_ecommerce.model.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileModel,Long> {
}

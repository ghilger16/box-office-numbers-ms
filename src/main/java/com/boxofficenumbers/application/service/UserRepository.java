package com.boxofficenumbers.application.service;

import com.boxofficenumbers.api.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<UserDto, String> {
    }

package com.boxofficenumbers.adapter;

import com.boxofficenumbers.api.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Long> {
}

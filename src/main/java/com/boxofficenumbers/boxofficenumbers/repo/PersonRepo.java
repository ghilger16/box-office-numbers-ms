package com.boxofficenumbers.boxofficenumbers.repo;

import com.boxofficenumbers.boxofficenumbers.model.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepo extends JpaRepository<person, Long> {
}

package com.sriteja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sriteja.model.Country;

@Repository
public interface CountryReposiotry extends JpaRepository<Country, Integer>{

}

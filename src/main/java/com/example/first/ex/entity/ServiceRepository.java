package com.example.first.ex.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.ex.form.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

}

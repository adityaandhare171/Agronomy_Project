package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Sellers;

@Repository
public interface SellersRepository extends JpaRepository<Sellers, Integer> {

}

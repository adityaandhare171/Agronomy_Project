package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	
	//@Query("select l.role,l.userid from Login l where email= :useremail and pass=: password")
	@Query(value="select l.role,l.userid from Login l where email= ?1 and pass = ?2", nativeQuery = true)
	public List<Object[]> checkLogin(String useremail,String password);
	
}

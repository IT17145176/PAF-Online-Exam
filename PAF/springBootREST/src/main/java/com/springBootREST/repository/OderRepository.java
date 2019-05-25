package com.springBootREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootREST.model.Oder;

public interface OderRepository extends JpaRepository<Oder, Long> {

}

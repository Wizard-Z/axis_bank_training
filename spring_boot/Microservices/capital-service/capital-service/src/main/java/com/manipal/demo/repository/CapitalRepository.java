package com.manipal.demo.repository;

import com.manipal.demo.model.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalRepository extends JpaRepository<Capital,String> {
    Capital findByname(String name);
}

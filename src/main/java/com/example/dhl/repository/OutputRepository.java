package com.example.dhl.repository;

import com.example.dhl.entity.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutputRepository extends JpaRepository<Output, Long>{

}

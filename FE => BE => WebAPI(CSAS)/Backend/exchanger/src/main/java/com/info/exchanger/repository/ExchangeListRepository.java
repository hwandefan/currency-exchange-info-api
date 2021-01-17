package com.info.exchanger.repository;

import com.info.exchanger.model.ExchangeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repository for CRUD manipulations
@Repository
public interface ExchangeListRepository extends JpaRepository<ExchangeList, String> {

}

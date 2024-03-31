package com.stocksDemo.stocksDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocksDemo.stocksDemo.model.NiftyFiftyTable;
import com.stocksDemo.stocksDemo.model.bankNiftyTable;

@Repository
public interface stockDataRepositoryNifty  extends JpaRepository<NiftyFiftyTable, Integer>{

	

}



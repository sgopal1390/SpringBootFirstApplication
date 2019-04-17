package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bean.StockEntity;

@Repository
public interface ManyManyRepositoryForStock extends JpaRepository<StockEntity,Long> {

}

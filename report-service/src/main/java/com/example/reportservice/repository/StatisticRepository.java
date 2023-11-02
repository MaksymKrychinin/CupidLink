package com.example.reportservice.repository;

import com.example.reportservice.data.Statistic;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends MongoRepository<Statistic, String> {

    Optional<Statistic> findByUserId(Long userId);

    @Override
    Statistic save(Statistic statistic);
}

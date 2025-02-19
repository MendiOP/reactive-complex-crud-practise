package com.complex.Query.repository;

import com.complex.Query.model.Prescription;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends ReactiveCrudRepository<Prescription, Long> {

}

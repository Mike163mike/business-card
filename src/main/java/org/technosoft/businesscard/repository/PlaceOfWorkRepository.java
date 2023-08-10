package org.technosoft.businesscard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technosoft.businesscard.model.PlaceOfWork;

@Repository
public interface PlaceOfWorkRepository extends JpaRepository<PlaceOfWork, Integer> {
}
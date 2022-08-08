package com.imranrauf.metrics.repository;

import com.imranrauf.metrics.domain.WorldConcept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Imran Rauf Created on 21-Oct-2019
 */

public interface CommonConceptRepository extends JpaRepository<WorldConcept,String> {

    List<WorldConcept> findByName(String name);
    List<WorldConcept> findByNameIgnoreCaseStartingWith(String name);
}

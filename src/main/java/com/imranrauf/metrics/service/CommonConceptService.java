package com.imranrauf.metrics.service;

import com.imranrauf.metrics.domain.WorldConcept;
import com.imranrauf.metrics.exceptions.ConceptNotFoundException;
import com.imranrauf.metrics.repository.CommonConceptRepository;
import com.imranrauf.metrics.vo.CommonConceptVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Imran Rauf Created on 21-Oct-2019
 */

@Service
@Transactional(readOnly = true)
public class CommonConceptService {

    private final CommonConceptRepository conceptRepository;

    public CommonConceptService(CommonConceptRepository conceptRepository) {
        this.conceptRepository = conceptRepository;
    }
    @Transactional
    public WorldConcept update(String id, WorldConcept conceptVO){
        return conceptRepository.save(conceptVO);
    }

    @Transactional
    public WorldConcept create(CommonConceptVO conceptVO){
        WorldConcept worldConcept = new WorldConcept();
        worldConcept.setName(conceptVO.getName());
        worldConcept.setDescription(conceptVO.getDescription());
        return this.conceptRepository.save(worldConcept);
    }

    @Transactional
    public void delete(String id){

        this.conceptRepository.deleteById(id);

        System.out.println("Record removed successfully!");
    }

    public List<WorldConcept> findAll(){

        System.out.println("findAll successfully!");
        return this.conceptRepository.findAll();

    }

        public List<WorldConcept> findByName(String name) {
            return this.conceptRepository.findByName(name);
        }
        public List<WorldConcept> findByNameStartingWith(String name) {
            return
            this.conceptRepository.findByNameIgnoreCaseStartingWith(name);
    }
    public WorldConcept findOne(String id) {
        final Optional<WorldConcept> concept =
            this.conceptRepository.findById(id);
        if (concept.isPresent()) {
            return concept.get();
        } else {
            throw new ConceptNotFoundException(id);
        }
    }
}

package com.imranrauf.metrics.resource;

import com.imranrauf.metrics.domain.WorldConcept;
import com.imranrauf.metrics.service.CommonConceptService;
import com.imranrauf.metrics.vo.CommonConceptVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Imran Rauf Created on 21-Oct-2019
 */

@RestController
@RequestMapping("/api/concept")
@Api(tags = "concept", description = "Concept API")
public class CommonConceptResource {

    private final CommonConceptService commonConceptService;


    public CommonConceptResource(CommonConceptService commonConceptService) {
        this.commonConceptService = commonConceptService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Concept",notes = "Find the Category by ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200,message = "Category found"),
        @ApiResponse(code = 404,message = "Category not found"),
    })
    public ResponseEntity<WorldConcept> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(this.commonConceptService.findOne(id));
    }

    @GetMapping
    @ApiOperation(value = "List categories",notes = "List all categories")
    @ApiResponses(value = {
        @ApiResponse(code = 200,message = "Concept found"),
        @ApiResponse(code = 404,message = "Concept not found")
    })
    public ResponseEntity<List<WorldConcept>> findAll(){
        return ResponseEntity.ok(this.commonConceptService.findAll());
    }

    @PostMapping
    @ApiOperation(value = "Create concept",notes = "It permits to create a new Concept")
    @ApiResponses(value = {
        @ApiResponse(code = 201,message = "Concept created successfully"),
        @ApiResponse(code = 400,message = "Invalid request")
    })
    public ResponseEntity<WorldConcept> newConcept(@RequestBody CommonConceptVO Concept){

        return new ResponseEntity<>(this.commonConceptService.create(Concept), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove Concept",notes = "It permits to remove a Concept")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
        @ApiResponse(code = 200,message = "Concept removed successfully"),
        @ApiResponse(code = 404,message = "Concept not found")
    })
    public ResponseEntity<WorldConcept>  removeWorldConcept(@PathVariable("id") String id){
        //return new ResponseEntity<>(this.commonConceptService.delete(id);, HttpStatus.);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Record removed", id );
        this.commonConceptService.delete(id);
        return new ResponseEntity<>(new WorldConcept(),headers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update Concept",notes = "It permits to update a Concept")
    @ApiResponses(value = {
        @ApiResponse(code = 200,message = "Concept update successfully"),
        @ApiResponse(code = 404,message = "Concept not found"),
        @ApiResponse(code = 400,message = "Invalid request")
    })
    public ResponseEntity<WorldConcept> updateWorldConcept(@PathVariable("id") String id,CommonConceptVO commonConcept){
        return new ResponseEntity<>(new WorldConcept(), HttpStatus.OK);
    }

    @GetMapping("/query")
    @ApiOperation(value = "List categories by name with starting",notes = "List categories by name with starting")
    @ApiResponses(value = {
        @ApiResponse(code = 200,message = "Categories found"),
        @ApiResponse(code = 404,message = "Concept not found")
    })
    public ResponseEntity<List<WorldConcept>> findByNameStartingWith(@RequestParam("name") String name){
        return ResponseEntity.ok(this.commonConceptService.findByNameStartingWith(name));
    }

}

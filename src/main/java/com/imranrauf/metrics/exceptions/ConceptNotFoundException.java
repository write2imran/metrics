package com.imranrauf.metrics.exceptions;

import lombok.Getter;

/**
 * @author Imran Rauf Created on 21-Oct-2019
 */

public class ConceptNotFoundException extends RuntimeException{

    @Getter
    private final String id;

    public ConceptNotFoundException(String id) {
        this.id = id;
    }
}



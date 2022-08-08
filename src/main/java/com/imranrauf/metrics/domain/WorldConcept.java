package com.imranrauf.metrics.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Imran Rauf Created on 20-Oct-2019
 */

@Data
@Entity
@Table(name="concepts")
public class WorldConcept {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String id;
    String name;
    String description;

}

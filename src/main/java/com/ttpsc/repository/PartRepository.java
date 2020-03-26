package com.ttpsc.repository;

import com.ttpsc.entity.Part;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartRepository extends CrudRepository<Part, Long> {

    List<Part> findAll();

}

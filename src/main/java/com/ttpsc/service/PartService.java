package com.ttpsc.service;

import com.ttpsc.entity.Part;

import java.util.List;
import java.util.Optional;

public interface PartService {
    Optional<Part> getPart(Long id);
    void addPart(Part part);
    void updatePart(Long id, Part part);
    void deletePart(Long id);
    List<Part> getParts();
}

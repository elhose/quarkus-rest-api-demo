package com.ttpsc.service;

import com.ttpsc.entity.Part;
import com.ttpsc.repository.PartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {

    private PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public Optional<Part> getPart(Long id) {
        return partRepository.findById(id);
    }

    @Override
    public void addPart(Part part) {
        partRepository.save(part);
    }

    @Override
    public void updatePart(Long id, Part part) {
        Optional<Part> foundPart = partRepository.findById(id);

        if (foundPart.isPresent()) {
            part.setId(foundPart.get().getId());
        }

        partRepository.save(part);
    }

    @Override
    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }

    @Override
    public List<Part> getParts() {
        return partRepository.findAll();
    }
}

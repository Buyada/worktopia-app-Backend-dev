package com.groupe.Worktopia.service.Conge;

import com.groupe.Worktopia.entities.Conge;
import com.groupe.Worktopia.entities.Permission;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.repository.CongeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongeServiceImpl implements CongeService{

    private final CongeRepo congeRepo;

    public CongeServiceImpl(CongeRepo congeRepo) {
        this.congeRepo = congeRepo;
    }

    @Override
    public Conge addConge(Conge conge) {
        return this.congeRepo.save(conge);
    }

    @Override
    public List<Conge> getAllConge() {
        return this.congeRepo.findAll();
    }

    @Override
    public Conge getCongeById(Long id) {
        Optional<Conge> conge = this.congeRepo.findById(id);
        if (conge.isEmpty())
            throw new ResourceNotFoundException("this conge was not found");
        return conge.get();
    }

    @Override
    public Conge updateConge(Conge newConge, Long id) {
        Conge oldConge = this.congeRepo.findById(id).get();
        oldConge.setRaisonConge(newConge.getRaisonConge());
        oldConge.getRetourConge();
        return this.congeRepo.saveAndFlush(oldConge);
    }

    @Override
    public void deleteConge(Long id) {
        this.congeRepo.deleteById(id);

    }
}

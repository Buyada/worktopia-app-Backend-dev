package com.groupe.Worktopia.service.Conge;

import com.groupe.Worktopia.entities.Conge;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.repository.CongeRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        // Si l'ID est déjà défini dans l'objet Conge, il peut poser problème.
        if (conge.getIdConge() != null) {
            throw new IllegalArgumentException("L'ID doit être nul lors de l'ajout d'un nouveau Conge");
        }

        conge.setCreatedAt(new Date());  // Assurez-vous de définir toutes les informations nécessaires
        return this.congeRepo.save(conge); // Enregistrer l'entité avec un ID auto-généré
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
        Conge oldConge = this.congeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le congé avec l'ID " + id + " n'a pas été trouvé"));

        oldConge.setRaisonConge(newConge.getRaisonConge());
        oldConge.setRetourConge(newConge.getRetourConge()); // Ne pas oublier de mettre à jour ce champ.

        return this.congeRepo.saveAndFlush(oldConge);
    }


    @Override
    public void deleteConge(Long id) {
        if (!this.congeRepo.existsById(id)) {
            throw new ResourceNotFoundException("Le congé avec l'ID " + id + " n'a pas été trouvé");
        }
        this.congeRepo.deleteById(id);
    }
}

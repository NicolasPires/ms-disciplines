package com.nksolucoes.msdisciplines.datasources;

import com.nksolucoes.msdisciplines.datasources.repositories.DisciplinesClientRepository;
import com.nksolucoes.msdisciplines.entities.Discipline;
import com.nksolucoes.msdisciplines.repositories.DisciplinesRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DisciplinesDataSource implements DisciplinesRepository {

    private DisciplinesClientRepository disciplinesClientRepository;

    public DisciplinesDataSource(DisciplinesClientRepository disciplinesClientRepository) {
        this.disciplinesClientRepository = disciplinesClientRepository;
    }

    @Override
    public List<Discipline> getAll() {
        return this.disciplinesClientRepository.findAll();
    }

    @Override
    public Discipline getDisciplineById(Long id) {
        Optional<Discipline> disciplineOptional = this.disciplinesClientRepository.findById(id);
        if (disciplineOptional.isEmpty()) {
            new RuntimeException("Discipline Not Found!");
        }
        return disciplineOptional.get();
    }

    @Override
    public Discipline createDiscipline(Discipline discipline) {
        return this.disciplinesClientRepository.save(discipline);
    }

    @Override
    public Discipline updateDiscipline(Discipline discipline) {
        return this.disciplinesClientRepository.save(discipline);
    }

    @Override
    public void deleteDiscipline(Long id) {
        this.disciplinesClientRepository.deleteById(id);
    }
}

package com.nksolucoes.msdisciplines.interactors;

import com.nksolucoes.msdisciplines.entities.Discipline;
import com.nksolucoes.msdisciplines.repositories.DisciplinesRepository;
import com.nksolucoes.msdisciplines.transportlayer.documentacao.model.DisciplinesDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DisciplinesUseCase {

    private final DisciplinesRepository disciplinesRepository;

    public DisciplinesUseCase(DisciplinesRepository disciplinesRepository) {
        this.disciplinesRepository = disciplinesRepository;
    }

    public Discipline createDiscipline(Discipline discipline) {
        return this.disciplinesRepository.createDiscipline(discipline);
    }

    public Discipline getDisciplineById(Long disciplineId) {
        Discipline disciplineData = this.disciplinesRepository.getDisciplineById(disciplineId);
        if (Objects.isNull(disciplineData)) {
            new RuntimeException("No content Discipline!");
        }
        return disciplineData;
    }

    public List<Discipline> getAll() {
        return this.disciplinesRepository.getAll();
    }

    public ResponseEntity<Void> deleteDiscipline(Long disciplineId) {
        Discipline disciplineData = this.disciplinesRepository.getDisciplineById(disciplineId);
        if (!Objects.isNull(disciplineData)) {
            this.disciplinesRepository.deleteDiscipline(disciplineId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            throw new RuntimeException("Unable to find discipline for delete");
        }
    }

    public Discipline updateDiscipline(Discipline discipline, Long disciplineId) {
        Discipline disciplineData = this.disciplinesRepository.getDisciplineById(disciplineId);

        if (!Objects.isNull(disciplineData)) {
            return this.disciplinesRepository.updateDiscipline(Discipline.builder()
                    .id(disciplineData.getId())
                    .name(discipline.getName())
                    .grade(discipline.getGrade())
                    .createDate(discipline.getCreateDate())
                    .build());
        } else {
            throw new RuntimeException("Unable to find discipline for update");
        }
    }
}

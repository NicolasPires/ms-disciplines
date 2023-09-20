package com.nksolucoes.msdisciplines.transportlayer;

import com.nksolucoes.msdisciplines.entities.Discipline;
import com.nksolucoes.msdisciplines.interactors.DisciplinesUseCase;
import com.nksolucoes.msdisciplines.transportlayer.documentacao.model.DisciplinesDetail;
import com.nksolucoes.msdisciplines.transportlayer.documentacao.model.DisciplinesInput;
import com.nksolucoes.msdisciplines.transportlayer.documentacao.openapi.DisciplinesApi;
import com.nksolucoes.msdisciplines.transportlayer.mapper.DisciplinesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DisciplinesHttp implements DisciplinesApi {

    private final DisciplinesUseCase disciplinesUseCase;

    public DisciplinesHttp(DisciplinesUseCase disciplinesUseCase) {
        this.disciplinesUseCase = disciplinesUseCase;
    }


    @Override
    public ResponseEntity<DisciplinesDetail> createDiscipline(DisciplinesInput disciplinesInput) {
        Discipline discipline = null;
        discipline = disciplinesUseCase.createDiscipline(DisciplinesMapper.INSTANCE.map(disciplinesInput));

        return ResponseEntity.status(HttpStatus.CREATED).body(DisciplinesMapper.INSTANCE.mapDetail(discipline));
    }

    @Override
    public ResponseEntity<DisciplinesDetail> getDisciplineById(Long disciplineId) {
        Discipline discipline = null;
        discipline = disciplinesUseCase.getDisciplineById(disciplineId);

        return ResponseEntity.ok(DisciplinesMapper.INSTANCE.mapDetail(discipline));
    }

    @Override
    public ResponseEntity<List<DisciplinesDetail>> getDisciplines(String title) {
        List<Discipline> disciplineList = null;
        disciplineList = disciplinesUseCase.getAll();
        return ResponseEntity.ok(DisciplinesMapper.INSTANCE.mapListDetail(disciplineList));
    }

    @Override
    public ResponseEntity<Void> removeDiscipline(Long disciplineId) {
        return disciplinesUseCase.deleteDiscipline(disciplineId);
    }

    @Override
    public ResponseEntity<DisciplinesDetail> updateDiscipline(Long disciplineId, DisciplinesInput disciplinesInput) {
        Discipline discipline = null;
        discipline = disciplinesUseCase.updateDiscipline(DisciplinesMapper.INSTANCE.map(disciplinesInput), disciplineId);
        return ResponseEntity.status(HttpStatus.OK).body(DisciplinesMapper.INSTANCE.mapDetail(discipline));
    }
}

package com.nksolucoes.msdisciplines.repositories;

import com.nksolucoes.msdisciplines.entities.Discipline;

import java.util.List;

public interface DisciplinesRepository {
    List<Discipline> getAll();
    Discipline getDisciplineById(Long id);
    Discipline createDiscipline(Discipline discipline);
    Discipline updateDiscipline(Discipline discipline);
    void deleteDiscipline(Long id);

}

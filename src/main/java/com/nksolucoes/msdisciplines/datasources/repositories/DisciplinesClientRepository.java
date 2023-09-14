package com.nksolucoes.msdisciplines.datasources.repositories;

import com.nksolucoes.msdisciplines.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinesClientRepository extends JpaRepository<Discipline, Long> {
}

package com.nksolucoes.msdisciplines.transportlayer.mapper;

import com.nksolucoes.msdisciplines.entities.Discipline;
import com.nksolucoes.msdisciplines.transportlayer.documentacao.model.DisciplinesDetail;
import com.nksolucoes.msdisciplines.transportlayer.documentacao.model.DisciplinesInput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DisciplinesMapper {

    DisciplinesMapper INSTANCE = Mappers.getMapper(DisciplinesMapper.class);

    Discipline map(DisciplinesInput disciplinesInput);

    DisciplinesDetail mapDetail(Discipline discipline);

    default List<DisciplinesDetail> mapListDetail(List<Discipline> disciplineList) {
        final List<DisciplinesDetail> disciplineDetailList = new ArrayList<>();
        for (Discipline discipline: disciplineList) {
            DisciplinesDetail studentsDetail = DisciplinesMapper.INSTANCE.mapDetail(discipline);
            disciplineDetailList.add(studentsDetail);
        }
        return disciplineDetailList;
    }

}

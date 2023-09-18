package com.nksolucoes.msdisciplines.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tab_disciplines")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disciplineId;
    private String name;
    private String grade;
}

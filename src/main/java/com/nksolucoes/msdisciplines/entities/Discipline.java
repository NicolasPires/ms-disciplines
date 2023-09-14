package com.nksolucoes.msdisciplines.entities;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id;
    private String name;
    private String grade;
    private Date createDate;
}

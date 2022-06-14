package com.arno.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "registry")
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "call_id")
    private int callId;

    @Column(name = "complaints")
    private String complaints;

    @Column(name = "anamnesis")
    private String anamnesis;

    @Column(name = "recommendation")
    private String recommendation;

    @Column (name = "diagnoses")
    private String diagnosesId;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "obj_id")
    private int objId;

    @Column(name = "surveys")
    private String surveys;
}

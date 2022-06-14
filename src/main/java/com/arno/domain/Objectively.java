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
@Table(name = "objectively")
public class Objectively {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Registry.class)
    @JoinColumn(name = "registry_id")
    private Registry registry;

    @Column(name = "general_state")
    private String generalState;

    @Column(name = "body_build")
    private String bodyBuild;

    @Column(name = "skin")
    private String skin;

    @Column(name = "node_gland")
    private String nodeAndGland;

    @Column(name = "temp")
    private String temperature;

    @Column(name = "pharynx")
    private String pharynx;

    @Column(name = "resp_rate")
    private String respiratoryRate;

    @Column(name = "breathing")
    private String breathing;

    @Column(name = "arterial_pressure")
    private String arterialPressure;

    @Column(name = "pulse")
    private String pulse;

    @Column(name = "heart_tones")
    private String heartTones;

    @Column(name = "abdomen")
    private String abdomen;

    @Column(name = "liver")
    private String liver;

    @Column(name = "reg_id")
    private int registryId;

    @Column(name = "pensioner")
    private byte pensioner;

    @Column(name = "sick")
    private byte sick;

}

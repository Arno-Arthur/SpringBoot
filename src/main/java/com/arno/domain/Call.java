package com.arno.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "call")

public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = GeoPoint.class)
    @JoinColumn(name = "geo_point_id")
    private GeoPoint geoPoint;

    @Column(name = "call_time")
    private Date callTime;

    @Column(name = "edit_card_date")
    private Date editCardDate;

    @Column(name = "reason")
    private String reason;

    @Column(name = "bcc")
    private String bcc;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "sex")
    private byte sex;

    @Column(name = "residence")
    private String residence;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "snils")
    private long snils;

    @Column(name = "polis")
    private long polis;

    @Column(name = "passport")
    private String passport;
}

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
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Token.class)
    @JoinColumn(name = "token_id")
    private Token token;

    @Column(name = "working_position")
    private String workingPosition;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Organization.class)
    @JoinColumn(name = "organization_id")
    private Organization organization;

}

package com.example.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_role")
    private Boolean role;

    @Column(name = "member_name")
    private String name;

}
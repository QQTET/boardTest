package com.example.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_comment")
    private String comment;

    @Column(name = "board_view")
    private int view;

    @Column(name = "board_role_view")
    private int roleView;

    @Column(name = "board_date")
    private LocalDate date;

    @Column(name = "board_good")
    private int good;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

}

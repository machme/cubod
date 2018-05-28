package com.community.cubod.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bookmark")
@Getter
@Setter
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name = "board_no")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

}

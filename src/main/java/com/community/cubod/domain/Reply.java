package com.community.cubod.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reply")
@Getter
@Setter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String content;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

}

package com.community.cubod.domain;

import com.community.cubod.domain.id.BoardTagId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "board_tag")
@Setter
@Getter
@IdClass(BoardTagId.class)
public class BoardTag {
    @Id
    @ManyToOne
    @JoinColumn(name = "board_no")
    private Board board;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_no")
    private Tag tag;

}

package com.community.cubod.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "file")
@Getter
@Setter
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String originName;
    private String mimeType;
    private String path;
    private Integer size;

    @ManyToOne
    @JoinColumn(name = "board_no")
    private Board board;

    public void setBoard(Board board){
        this.board = board;
        if(!board.getFileInfoList().contains(this)){
            board.getFileInfoList().add(this);
        }
    }

}

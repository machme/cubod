package com.community.cubod.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String title;
    private String content;
    private Integer viewCount;
    private Integer recommendCount;
    private LocalDateTime writeTime;
    private String useYn;

    @ManyToOne
    @JoinColumn(name = "category_no")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BoardTag> boardTagList = new ArrayList<BoardTag>();

    public void addBoardTag(BoardTag boardTag){
        this.boardTagList.add(boardTag);
        if(boardTag.getBoard() != this){
            boardTag.setBoard(this);
        }
    }

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FileInfo> fileInfoList = new ArrayList<FileInfo>();

    public void addFile(FileInfo fileInfo){
        this.fileInfoList.add(fileInfo);
        if(fileInfo.getBoard() != this){
            fileInfo.setBoard(this);
        }
    }


}

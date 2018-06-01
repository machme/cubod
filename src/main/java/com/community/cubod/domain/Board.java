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
    @JoinColumn(name = "member_no")
    private Member member;

    public void setMember(Member member){
        this.member = member;
        if(!member.getBoardList().contains(this)){
            member.getBoardList().add(this);
        }
    }

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BoardTag> boardTagList = new ArrayList<BoardTag>();

    public void addBoardTag(BoardTag boardTag){
        this.boardTagList.add(boardTag);
        if(boardTag.getBoard() != this){
            boardTag.setBoard(this);
        }
    }

    @OneToMany
    @JoinColumn(name = "board_no")
    private List<FileInfo> fileInfoList = new ArrayList<FileInfo>();

    public void addFileInfo(FileInfo fileInfo){
        this.fileInfoList.add(fileInfo);
    }


    @OneToMany
    @JoinColumn(name = "board_no")
    private List<Reply> reply = new ArrayList<Reply>();

    public Integer getReplyCount(){
        return reply.size();
    }

}

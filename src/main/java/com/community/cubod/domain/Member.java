package com.community.cubod.domain;

import com.community.cubod.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String nickname;
    private String password;
    private String email;
    private LocalDateTime regDate;
    private String useYn;

    public Member(MemberDto memberDto){
        this.email = memberDto.getEmail();
        this.nickname = memberDto.getNickname();
        this.password = memberDto.getPassword();
    }


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> boardList = new ArrayList<Board>();

    public void addBoard(Board board){
        this.boardList.add(board);
        if(board.getMember() != this){
            board.setMember(this);
        }
    }

//    @OneToMany(mappedBy = "bookmark", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Bookmark> bookmarkList = new ArrayList<Bookmark>();

//    @OneToMany(mappedBy = "reply", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Reply> replyList = new ArrayList<Reply>();
}

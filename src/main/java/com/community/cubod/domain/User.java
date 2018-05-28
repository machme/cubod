package com.community.cubod.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String id;
    private String password;
    private String email;
    private LocalDateTime regDate;
    private String useYn;

//    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Board> boardList = new ArrayList<Board>();

//    @OneToMany(mappedBy = "bookmark", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Bookmark> bookmarkList = new ArrayList<Bookmark>();

//    @OneToMany(mappedBy = "reply", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Reply> replyList = new ArrayList<Reply>();
}

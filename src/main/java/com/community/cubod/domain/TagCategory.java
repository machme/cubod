package com.community.cubod.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tagCategory")
@Getter
@Setter
public class TagCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String name;

    @OneToMany(mappedBy = "tagCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TagGroup> tagGroupList;

    public void addTagGroup(TagGroup tagGroup){
        tagGroupList.add(tagGroup);
        if(tagGroup.getTagCategory() != this){
            tagGroup.setTagCategory(this);
        }
    }
}

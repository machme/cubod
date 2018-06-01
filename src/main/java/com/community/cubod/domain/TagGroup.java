package com.community.cubod.domain;

import com.community.cubod.domain.id.TagGroupId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tag_group")
@Getter
@Setter
@IdClass(TagGroupId.class)
public class TagGroup {
    @Id
    @OneToOne
    @JoinColumn(name = "tag_no")
    private Tag tag;

    @Id
    @ManyToOne
    @JoinColumn(name = "tagCategory_no")
    private TagCategory tagCategory;

    public void setTagCategory(TagCategory tagCategory){
        this.tagCategory = tagCategory;
        if(!tagCategory.getTagGroupList().contains(this)){
            tagCategory.getTagGroupList().add(this);
        }
    }

}

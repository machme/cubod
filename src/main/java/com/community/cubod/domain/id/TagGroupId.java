package com.community.cubod.domain.id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class TagGroupId implements Serializable {
    private Long tag;
    private Long tagCategory;
}

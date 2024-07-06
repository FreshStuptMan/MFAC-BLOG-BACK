package com.mfac.pojo.vo;

import com.mfac.pojo.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagListVO extends Tag {
    private String creatorName;
}

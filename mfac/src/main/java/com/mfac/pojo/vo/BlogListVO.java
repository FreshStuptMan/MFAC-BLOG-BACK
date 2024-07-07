package com.mfac.pojo.vo;

import com.mfac.pojo.entity.Blog;
import com.mfac.pojo.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogListVO extends Blog {
    private String authorName;
    private String classifyName;
    private List<Tag> tags;
}

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
public class BlogDetailVO extends Blog {
    private String classifyName;
    private String authorName;
    private List<Tag> tags;
}

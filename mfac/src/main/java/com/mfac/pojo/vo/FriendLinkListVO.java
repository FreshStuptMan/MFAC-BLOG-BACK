package com.mfac.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendLinkListVO {
    private Long id;
    private String name;
    private String link;
    private String description;
    private String avatar;
    private String author;
    private String color;
}

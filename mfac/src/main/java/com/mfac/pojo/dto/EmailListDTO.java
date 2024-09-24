package com.mfac.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailListDTO {
    private Integer pageSize;
    private Integer pageNum;
    private String name;
    private String email;
    private Integer status;
    private String emailType;
}

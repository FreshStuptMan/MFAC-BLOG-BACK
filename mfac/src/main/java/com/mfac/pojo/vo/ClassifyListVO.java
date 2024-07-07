package com.mfac.pojo.vo;

import com.mfac.pojo.entity.Classify;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassifyListVO extends Classify {
    private String creatorName;
}

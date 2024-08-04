package com.mfac.pojo.vo;

import com.mfac.pojo.entity.Tool;
import com.mfac.pojo.entity.ToolType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToolTypeDetailVO extends ToolType {
    private List<Tool> tools;
}

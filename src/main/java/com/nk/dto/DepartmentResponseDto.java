package com.nk.dto;

import lombok.Data;

@Data
public class DepartmentResponseDto {
    private String id;
    private String deptName;
    private String location;
    private String managerName;
}

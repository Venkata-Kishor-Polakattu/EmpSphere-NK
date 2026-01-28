package com.nk.dto;

import lombok.Data;

@Data
public class DepartmentResponseDto {
    private Long id;
    private String deptCode;
    private String deptName;
    private String location;
    private String managerName;
}

package com.nk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentRequestDto {

    @NotNull
    @NotBlank(message = " department name should not be blank")
    private String deptName;

    @NotNull
    @NotBlank(message = "Location should not be blank")
    private String location;

    @NotNull
    @NotBlank(message = "Manager should not be blank")
    private String managerName;
}

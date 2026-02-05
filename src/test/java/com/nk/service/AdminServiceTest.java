package com.nk.service;

import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    public AdminServices service;

    @Test
    public void testCreateDepartment(){
        DepartmentRequestDto dto=new DepartmentRequestDto();
        dto.setDeptName("Sales");
        dto.setLocation("Hyderabad");
        dto.setManagerName("Guru");
        DepartmentResponseDto department = service.createDepartment(dto);
        System.out.println("Successfully created the department :"+department.toString());
    }

    @Test
    public void testUpdateDepartment(){
        DepartmentRequestDto dto=new DepartmentRequestDto();
        dto.setDeptName("Testing");
        dto.setLocation("Vizag");
        dto.setManagerName("Kishor");
        service.updateDepartment("DEPT2",dto);
    }

    @Test
    public void testTransferDepartment(){
        service.transferDepartment("EMP-0002","DEPT01");
        System.out.println("Successfully transferred the department");
    }

    @Test
    public void testDeleteDepartment() throws Exception {
        String deptCode="DEPT2";
        service.deleteDepartment(deptCode);
        System.out.println("Successfully deleted the department :"+deptCode);
    }
    @Test
    public void testIncreaseSalaryByPercentage(){
        String empCode = "EMP-0001";
        Integer percentage = 5;
        String s = service.increaseSalaryByPercentage(empCode, percentage);
        System.out.println(s);
    }

}

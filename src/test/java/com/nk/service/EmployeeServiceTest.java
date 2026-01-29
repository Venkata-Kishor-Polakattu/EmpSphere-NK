package com.nk;

import com.nk.dto.AddressDto;
import com.nk.dto.EmployeeRequestDto;
import com.nk.enums.EmpGender;
import com.nk.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    public EmployeeService service;


    @Test
    public void testCreateEmployee() {
        EmployeeRequestDto request = new EmployeeRequestDto();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmail("ramana@gmail.com");
        request.setPassword("12345");
        request.setDeptId(1L);
        request.setDesignation("Tester");
        request.setGender(EmpGender.MALE);
        request.setDateOfBirth(LocalDate.of(1990, 1, 12));
        request.setJoiningDate(LocalDate.now());
        request.setPhoneNumber("9618331963");
        AddressDto dto = new AddressDto();
        dto.setStreet("Vivekananda Colony");
        dto.setCity("Nandyal");
        dto.setState("Andhra Pradesh");
        dto.setCountry("India");
        dto.setPinCode("518135");
        request.setAddress(dto);
        service.createEmployee(request);
    }
}

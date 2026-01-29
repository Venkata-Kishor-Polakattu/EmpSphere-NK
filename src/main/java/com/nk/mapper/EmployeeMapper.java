package com.nk.mapper;

import com.nk.beans.Address;
import com.nk.beans.Department;
import com.nk.beans.Employee;
import com.nk.dto.AddressDto;
import com.nk.dto.EmployeeRequestDto;
import com.nk.dto.EmployeeResponseDto;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class EmployeeMapper {

    // ===================== EmployeeEntity -> EmployeeResponseDto =====================
    public static EmployeeResponseDto toResponseDto(Employee employee) {
        if (employee == null) return null;
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setGender(employee.getGender());
        dto.setPhoneNumber(employee.getPhoneNumber());
        dto.setDateOfBirth(employee.getDateOfBirth());
        dto.setDesignation(employee.getDesignation());
        dto.setSalary(employee.getSalary());
        dto.setStatus(employee.getStatus());
        dto.setEmail(employee.getEmail());

        // Address mapping
        dto.setAddress(toAddressDto(employee.getAddress()));

        // Department mapping
        dto.setDepartment(DepartmentMapper.toDepartmentResponseDto(employee.getDepartment()));

        return dto;
    }
    // ===================== RequestDto -> EmployeeEntity =====================
    public static Employee toEmployee(EmployeeRequestDto dto, Department department){
        if (dto == null) return null;
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setGender(dto.getGender());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setDesignation(dto.getDesignation());
        employee.setSalary(dto.getSalary());
        employee.setJoiningDate(dto.getJoiningDate());
        employee.setStatus(dto.getStatus());
        employee.setEmail(dto.getEmail());
        employee.setPassword(dto.getPassword());

        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());

        employee.setAddress(toAddressEntity(dto.getAddress()));
        employee.setDepartment(department);


        return  employee;
    }

    // ===================== Address Mapper =====================
    public static AddressDto toAddressDto(Address address) {
        if (address == null) return null;
        AddressDto dto = new AddressDto();
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setCountry(address.getCountry());
        dto.setPinCode(address.getPinCode());
        return dto;
    }

    public static Address toAddressEntity(AddressDto dto) {
        if (dto == null) return null;
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPinCode(dto.getPinCode());
        return address;
    }
}

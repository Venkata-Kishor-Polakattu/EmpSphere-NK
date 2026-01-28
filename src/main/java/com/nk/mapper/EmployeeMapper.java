package com.nk.mapper;

import com.nk.beans.Address;
import com.nk.beans.Department;
import com.nk.beans.Employee;
import com.nk.dto.AddressDto;
import com.nk.dto.DepartmentResponseDto;
import com.nk.dto.EmployeeResponseDto;

public class EmployeeMapper {

    // ===================== Employee -> EmployeeResponseDto =====================
    public static EmployeeResponseDto toEmployeeResponseDto(Employee employee) {
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

        dto.setAddress(toAddressDto(employee.getAddress()));
        dto.setDepartment(toDepartmentResponseDto(employee.getDepartment()));


        return dto;
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

    // ===================== Department Mapper =====================
    public static DepartmentResponseDto toDepartmentResponseDto(Department department) {
        if (department == null) return null;
        DepartmentResponseDto dto = new DepartmentResponseDto();
        dto.setId(department.getDepartmentId());
        dto.setDeptCode(department.getDeptCode());
        dto.setDeptName(department.getDeptName());
        dto.setLocation(department.getLocation());
        dto.setManagerName(department.getManagerName());
        return dto;
    }

    // ===================== EmployeeRequestDto -> Employee =====================

}

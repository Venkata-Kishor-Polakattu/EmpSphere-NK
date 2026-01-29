package com.nk.mapper;

import com.nk.beans.Employee;
import com.nk.dto.UpdatableEmployeeDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EmployeeMapper2 {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromDto(UpdatableEmployeeDto dto,@MappingTarget Employee employee);
}

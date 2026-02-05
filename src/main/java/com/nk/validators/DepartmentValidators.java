package com.nk.validators;

import com.nk.dto.DepartmentRequestDto;
import com.nk.exception.InvalidDepartmentName;
import com.nk.exception.InvalidLocation;
import com.nk.exception.InvalidManagerNameException;
import org.springframework.stereotype.Component;

@Component
public class DepartmentValidators {

    char[] numsAndSpecChars={'1','2','3','4','5','6','7','8','9','0','!','@','#','$','%','&','*'};

    public void validateDepartmentRequestDto(DepartmentRequestDto requestDto){

        String msg="should not contain numbers and special characters";

        for (char c : numsAndSpecChars) {
            if (requestDto.getDeptName().contains(String.valueOf(c))) {
                throw new InvalidDepartmentName("Department name "+msg);
            }
            if (requestDto.getLocation().contains(String.valueOf(c))) {
                throw new InvalidLocation("Location "+msg);
            }

            if (requestDto.getManagerName().contains(String.valueOf(c))) {
                throw new InvalidManagerNameException("Manager name "+msg);
            }
        }
    }
}

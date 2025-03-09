package com.crudoperation.jwt.utility;

import com.crudoperation.jwt.dto.UserAccountDto;
import com.crudoperation.jwt.entity.UserAccount;

public class MapUtils {
    public static UserAccountDto mapUserEntityToUserAccountDto(UserAccount userAccount) {
        UserAccountDto userAccountDto=new UserAccountDto();
        userAccountDto.setFirstName(userAccount.getFirstName());
        userAccountDto.setLastName(userAccount.getLastName());
        userAccountDto.setPassword(userAccount.getPassword());
        userAccountDto.setUsername(userAccount.getUsername());
        userAccountDto.setRole(userAccount.getRole());
        return userAccountDto;
    }
}

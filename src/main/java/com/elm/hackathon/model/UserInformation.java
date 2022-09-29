package com.elm.hackathon.model;

import com.elm.hackathon.model.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInformation {

    private String userId;

    private RoleEnum role;

    private String username ;


    @Override
    public boolean equals(Object obj) {
        UserInformation user = (UserInformation) obj;
        return this.userId.equals(user.getUserId())&&this.role.equals(user.getRole());
    }

}

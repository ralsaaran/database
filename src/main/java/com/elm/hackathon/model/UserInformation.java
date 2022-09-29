package com.elm.hackathon.model;

import com.elm.hackathon.model.enums.Role;

public class UserInformation {

    private String userId;

    private Role role;

    private String username ;

    public UserInformation() {
    }

    public UserInformation(String userId,Role role) {
        this.userId = userId;
        this.role = role;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMembership(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        UserInformation user = (UserInformation) obj;
        return this.userId.equals(user.getUserId())&&this.role.equals(user.getRole());
    }

    public void setUsername(String username){
        this.username = username;
    }
}

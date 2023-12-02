package com.backend.theWizardsBag.models;

import com.backend.theWizardsBag.utils.Objects.DataTransferObject;

public class User implements DataTransferObject {

    // ATTs
    private long userId;
    private String username;
    private String email;
    private String password;
    private String avatarImageUrl;

    // CONs
    public User() {
    }
    public User(String username, String email, String password, String avatarImageUrl) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatarImageUrl = avatarImageUrl;
    }

    // GETs
    public long getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getAvatarImageUrl() {
        return avatarImageUrl;
    }

    // SETs
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAvatarImageUrl(String avatarImageUrl) {
        this.avatarImageUrl = avatarImageUrl;
    }

    // OVRs
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatarImageUrl='" + avatarImageUrl + '\'' +
                '}';
    }



    // METs



}

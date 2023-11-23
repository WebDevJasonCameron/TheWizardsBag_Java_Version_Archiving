package com.backend.theWizardsBag.models;

public class User {

    // ATTs
    private int userId;
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
    public int getUser_id() {
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
    public String getAvatar_image_url() {
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
    public void setAvatar_image_url(String avatarImageUrl) {
        this.avatarImageUrl = avatarImageUrl;
    }

    // OVRs
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

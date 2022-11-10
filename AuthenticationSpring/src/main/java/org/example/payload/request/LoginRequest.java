package org.example.payload.request;

import org.springframework.lang.NonNull;

public class LoginRequest {
    @NonNull
    private String email;
    @NonNull
    private String password;

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}

package by.itcollege.entity;

import java.util.Objects;

public class User {

    private int id;

    private boolean isOnRequest;

    private String name;

    private String lastName;

    private String password;

    private Role role;

    public User(int id, boolean isOnRequest, String name, String lastName, String password, Role role) {
        this.id = id;
        this.isOnRequest = isOnRequest;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public User(boolean isOnRequest, String name, String lastName, String password, Role role) {
        this.isOnRequest = isOnRequest;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOnRequest() {
        return isOnRequest;
    }

    public void setOnRequest(boolean onRequest) {
        isOnRequest = onRequest;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                lastName.equals(user.lastName) &&
                password.equals(user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, password, role);
    }
}

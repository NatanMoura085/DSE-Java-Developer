package org.example.domain.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private boolean isAdmin;

    // Construtor corrigido para incluir isAdmin e id
    public User(int id, String name, String email, String address, String phone, boolean isAdmin) {
        this.id = id;  // Inicializando o id
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.isAdmin = isAdmin;  // Inicializando isAdmin
    }

    // Métodos getter e setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

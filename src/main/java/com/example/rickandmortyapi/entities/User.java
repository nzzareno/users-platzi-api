package com.example.rickandmortyapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    private String name;

    private String lastname;

    private String email;

    private String password;

    public User(){}

    public User(Long idUser, String email, String password){
        this.idUser = idUser;
        this.email = email;
        this.password = password;
    }

    public User(Long idUser, String name, String lastname, String email, String password){
        this.idUser = idUser;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, lastname, email, password);
    }
}

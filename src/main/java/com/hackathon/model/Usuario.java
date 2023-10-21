package com.hackathon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;
    @ElementCollection
    @Column(name = "tipo")
    private List<String> types;
    /*
    @Column(name = "tipo")
    private String type;
     */

    @Column(name = "precio")
    private float price;

    @ElementCollection
    //@Column(name = "color")
    private List<String> color;

    @Column(name = "es_gratis")
    private boolean isFree;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", tipo=" + types +
                ", precio=" + price +
                ", color=" + color +
                ", es gratis=" + isFree +
                '}';
    }
}

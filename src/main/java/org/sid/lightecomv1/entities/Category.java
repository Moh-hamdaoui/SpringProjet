package org.sid.lightecomv1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Entity //Pour une entitie JPA
@Data @NoArgsConstructor @AllArgsConstructor //Generer automatiquement les getters et les setters
public class Category implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category") //Une seule category pour plusieurs produits
    private Collection<Product> products;
}

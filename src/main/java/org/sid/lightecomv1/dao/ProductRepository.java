package org.sid.lightecomv1.dao;

import org.sid.lightecomv1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

// c'est pour gerer la base de donne
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource(path = "/selectedProducts")
    public List<Product> findBySelectedIsTrue();

    @RestResource(path = "/productsByKeyWord")
    public List<Product> findByNameContains(@Param("mc") String mc);

    @RestResource(path = "/availableProducts")
    public List<Product> findByAvailableIsTrue();

}

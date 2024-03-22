package org.sid.lightecomv1.dao;

import org.sid.lightecomv1.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// c'est pour gerer la base de donne
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

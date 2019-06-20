package com.in5Minutes.spring.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {
	public List<User> findByRole(@Param("role") String role);
}

// apis called http://localhost:8080/users/search/findByRole?role=Admin
// http://localhost:8080/users
// http://localhost:8080/users/1
// http://localhost:8080/users?size=2
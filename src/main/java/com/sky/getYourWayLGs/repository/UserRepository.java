package com.sky.getYourWayLGs.repository;

import com.sky.getYourWayLGs.entities.User;
import org.springframework.data.repository.CrudRepository;

//Repositories are classes or components that encapsulate the logic
// required to access data sources. They centralize common data access functionality,
// providing better maintainability and decoupling the infrastructure or technology
// used to access databases from the domain model layer.
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
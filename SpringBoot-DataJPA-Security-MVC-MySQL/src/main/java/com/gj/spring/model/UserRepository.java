package com.gj.spring.model;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<CustomUser, Long> {

	CustomUser findByUsername(final String username);
    void removeUserByUsername(String username);

}

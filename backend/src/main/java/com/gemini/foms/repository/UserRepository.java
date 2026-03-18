package com.gemini.foms.repository;


import com.gemini.foms.entity.User;
import com.gemini.foms.entity.enums.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> getUserByRole(Role role);

}

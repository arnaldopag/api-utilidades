package com.example.utilidades.commns.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.userName = (:userName)")
    public User findByUserName(@Param("userName") String userName);
}

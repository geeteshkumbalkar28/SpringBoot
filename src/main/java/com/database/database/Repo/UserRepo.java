package com.database.database.Repo;

import com.database.database.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "select * from database.user_info where first_name = :userName AND password  = :password",nativeQuery = true)
    Optional<User> findByUserId(@Param("userName") String userName,@Param("password") String password);
}

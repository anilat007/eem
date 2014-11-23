package com.kbit.eem.repository.usermanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kbit.eem.DBModel.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
	public User loadUserByUsername(@Param("username") final String username);
}

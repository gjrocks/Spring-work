package org.baeldung.config;

import java.util.Date;
import java.util.List;

import org.baeldung.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetail,Long>{

	public UserDetail findByUsername(String name);
	
	public UserDetail findByEmail(String email);
	
	public List<UserDetail> findAll();
	
	public List<UserDetail> findUserById(int id);
	
    
    @Modifying
    @Query("update UserDetail user set user.failedAttempts = failedAttempts+1 where user.username = :username")
    int updateFailedAttempts(@Param("username") String username);
    
    
    @Modifying
    @Query("update UserDetail user set user.failedAttempts = 0 where user.username = :username")
    int resetFailedAttempts(@Param("username") String username);

    @Query("select user.failedAttempts from UserDetail user where user.username = :username")
    int getFailedAttemptsCount(@Param("username") String username);
    
    @Modifying 
    @Query("update UserDetail user set user.lockedUntilDate = :dateLocked where user.username = :username")
    int updateLockDate(@Param("username") String username,@Param("dateLocked") Date dateLocked);
    
    @Modifying
    @Query("update UserDetail user set user.failedAttempts = 0 , user.password = :password , user.lockedUntilDate = :dateLocked  where user.username = :username")
    int resetPassword(@Param("username") String username,@Param("password") String password,@Param("dateLocked") Date dateLocked);
	
	
}

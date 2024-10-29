package com.kairos.repo;

import com.kairos.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("update Student set name=?1 where id=?2")
    @Modifying
    @Transactional
    void updateName(String name, Long id);
    @Query("Select s from Student s where s.name=?1")
    Optional<Student> findByName(String name);

}

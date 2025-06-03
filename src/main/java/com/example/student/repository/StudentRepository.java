package com.example.student.repository;

import com.example.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Find students by name containing the search string (case-insensitive)
    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Student> findByNameContainingIgnoreCase(@Param("searchTerm") String searchTerm, Pageable pageable);
    
    // Find students by class name
    Page<Student> findByClassName(String className, Pageable pageable);
    
    // Find students by name or class name containing the search string
    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
           "OR LOWER(s.className) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Student> searchByNameOrClass(@Param("searchTerm") String searchTerm, Pageable pageable);
}

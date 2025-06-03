package com.example.student.service;

import com.example.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Page<Student> getAllStudents(Pageable pageable);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
    Page<Student> searchStudents(String searchTerm, Pageable pageable);
    Page<Student> findByClassName(String className, Pageable pageable);
}

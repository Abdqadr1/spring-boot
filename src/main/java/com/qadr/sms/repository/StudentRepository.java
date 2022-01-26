package com.qadr.sms.repository;

import com.qadr.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Extending jpaRepository gives us the built-in methods to communicate with the database
 * You can also write a custom method with queries here
 * */
public interface StudentRepository extends JpaRepository<Student, Long> {

}

package com.qadr.sms.repository;

import com.qadr.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Extending jpaRepository gives us the built-in methods to communicate with the database
 * You can also write a custom methods with queries here
 * JpaRepository extends PagingAndSortingRepository,
 * PagingAndSortingRepository extends CrudRepository
 * */
public interface StudentRepository extends JpaRepository<Student, Long> {

}

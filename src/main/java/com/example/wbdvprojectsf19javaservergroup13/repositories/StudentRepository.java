package com.example.wbdvprojectsf19javaservergroup13.repositories;

import com.example.wbdvprojectsf19javaservergroup13.models.Analysis;
import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.Student;
import com.example.wbdvprojectsf19javaservergroup13.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("select student from Student student")
	List<Student> findAllStudents();

	List<Student> findAllByFaculty(Faculty faculty);

	Student findStudentById(Integer id);

	Student findStudentByUser(User user);

	@Query("select student from Student student where student.user.id =:userId")
	Student findStudentByUserId(@Param("userId") int userId);

	@Query("select student from Student student where student.user.id =:userId")
	Student findFacultyByUserIdOfStudent(@Param("userId") int userId);
}

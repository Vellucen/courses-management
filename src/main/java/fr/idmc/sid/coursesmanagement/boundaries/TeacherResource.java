package fr.idmc.sid.coursesmanagement.boundaries;

import fr.idmc.sid.coursesmanagement.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "teacher")
public interface TeacherResource extends JpaRepository<Teacher, String>{
}

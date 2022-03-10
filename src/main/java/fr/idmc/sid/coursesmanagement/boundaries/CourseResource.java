package fr.idmc.sid.coursesmanagement.boundaries;

import fr.idmc.sid.coursesmanagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseResource extends JpaRepository<Course, String> {
}

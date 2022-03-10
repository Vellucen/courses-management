package fr.idmc.sid.coursesmanagement.boundaries;

import fr.idmc.sid.coursesmanagement.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "classroom")
public interface ClassroomResource extends JpaRepository<Classroom, String>{
}

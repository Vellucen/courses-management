package fr.idmc.sid.coursesmanagement.boundaries;

import fr.idmc.sid.coursesmanagement.assemblers.CourseAssembler;
import fr.idmc.sid.coursesmanagement.entities.Course;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Course.class)
public class CourseRepresentation {
    private final CourseResource cr;
    private final CourseAssembler assembler;

    public CourseRepresentation(CourseResource cr, CourseAssembler assembler) {
        this.cr = cr;
        this.assembler = assembler;
    }

    //GET ONE Course
    @GetMapping(value = "/{courseId}")
    public ResponseEntity<?> getOneCourse(@PathVariable("courseId") String idCourse) {
        if (cr.existsById(idCourse)){
            return Optional.ofNullable(cr.findById(idCourse)).filter(Optional::isPresent)
                    .map(i -> ResponseEntity.ok(assembler.toModel(i.get())))
                    .orElse(ResponseEntity.notFound().build());
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

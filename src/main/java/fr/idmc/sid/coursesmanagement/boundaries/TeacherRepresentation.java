package fr.idmc.sid.coursesmanagement.boundaries;

import fr.idmc.sid.coursesmanagement.assemblers.TeacherAssembler;
import fr.idmc.sid.coursesmanagement.entities.Course;
import fr.idmc.sid.coursesmanagement.entities.Teacher;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/teacher", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Teacher.class)
public class TeacherRepresentation {

    private final TeacherResource tr;
    private final CourseResource cr;
    private final ClassroomResource clr;
    private final TeacherAssembler assembler;

    public TeacherRepresentation(TeacherResource tr, CourseResource cr, ClassroomResource clr, TeacherAssembler assembler) {
        this.tr = tr;
        this.cr = cr;
        this.clr = clr;
        this.assembler = assembler;
    }

    //GET ONE Teacher
    @GetMapping(value = "/{teacherId}")
    public ResponseEntity<?> getOneTeacher(@PathVariable("teacherId") String idTeacher) {
        if (tr.existsById(idTeacher)){
            return Optional.ofNullable(tr.findById(idTeacher)).filter(Optional::isPresent)
                    .map(i -> ResponseEntity.ok(assembler.toModel(i.get())))
                    .orElse(ResponseEntity.notFound().build());
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //POST ONE Course
    @PostMapping(value = "/{teacherId}/course/{classroomId}")
    public ResponseEntity<?> postOneCourse(@PathVariable("teacherId") String idTeacher, @RequestParam String date, @PathVariable("lassroomId") String idClassroom){
        Date datereservation = new Date(date);
        Course courseSave = new Course(
                UUID.randomUUID().toString(),
                datereservation,
                tr.getById(idTeacher),
                clr.getById(idClassroom)
        );
        if (courseSave.getClassRoom().isFree(datereservation)){
            Course saved = cr.save(courseSave);
            URI location = linkTo(CourseRepresentation.class).slash(saved.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}

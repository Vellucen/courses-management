package fr.idmc.sid.coursesmanagement.boundaries;

import fr.idmc.sid.coursesmanagement.assemblers.ClassroomAssembler;
import fr.idmc.sid.coursesmanagement.assemblers.TeacherAssembler;
import fr.idmc.sid.coursesmanagement.entities.Classroom;
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
@RequestMapping(value = "/classroom", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Classroom.class)
public class ClassroomRepresentation {
    private final ClassroomResource clr;
    private final ClassroomAssembler assembler;

    public ClassroomRepresentation(ClassroomResource clr, ClassroomAssembler assembler) {
        this.clr = clr;
        this.assembler = assembler;
    }

    //GET ONE Classroom
    @GetMapping(value = "/{classroomId}")
    public ResponseEntity<?> getOneClassroom(@PathVariable("classroomId") String idClassroom) {
        if (clr.existsById(idClassroom)){
            return Optional.ofNullable(clr.findById(idClassroom)).filter(Optional::isPresent)
                    .map(i -> ResponseEntity.ok(assembler.toModel(i.get())))
                    .orElse(ResponseEntity.notFound().build());
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package fr.idmc.sid.coursesmanagement.assemblers;

import fr.idmc.sid.coursesmanagement.boundaries.TeacherRepresentation;
import fr.idmc.sid.coursesmanagement.entities.Teacher;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TeacherAssembler implements RepresentationModelAssembler<Teacher, EntityModel<Teacher>> {
    @Override
    public EntityModel<Teacher> toModel(Teacher teacher){
        return EntityModel.of(teacher,
                linkTo(methodOn(TeacherRepresentation.class)
                        .getOneTeacher(teacher.getId())).withSelfRel());
    }
}

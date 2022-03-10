package fr.idmc.sid.coursesmanagement.assemblers;

import fr.idmc.sid.coursesmanagement.boundaries.ClassroomRepresentation;
import fr.idmc.sid.coursesmanagement.entities.Classroom;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ClassroomAssembler implements RepresentationModelAssembler<Classroom, EntityModel<Classroom>> {
    @Override
    public EntityModel<Classroom> toModel(Classroom classroom){
        return EntityModel.of(classroom,
                linkTo(methodOn(ClassroomRepresentation.class)
                        .getOneClassroom(classroom.getId())).withSelfRel());
    }
}

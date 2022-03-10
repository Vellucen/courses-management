package fr.idmc.sid.coursesmanagement.assemblers;

import fr.idmc.sid.coursesmanagement.boundaries.CourseRepresentation;
import fr.idmc.sid.coursesmanagement.entities.Course;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CourseAssembler implements RepresentationModelAssembler<Course, EntityModel<Course>> {
    @Override
    public EntityModel<Course> toModel(Course course){
        return EntityModel.of(course,
                linkTo(methodOn(CourseRepresentation.class)
                        .getOneCourse(course.getId())).withSelfRel());
    }
}

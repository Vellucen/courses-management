package fr.idmc.sid.coursesmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    @Id
    private String id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private Teacher prof;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Classroom classRoom;

    public Course(Date date, Teacher prof, Classroom classRoom){
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.prof = prof;
        this.classRoom = classRoom;
    }

}

package fr.idmc.sid.coursesmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String schoolteaching;

    public Teacher(String firstname, String lastname, String schoolteaching){
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.schoolteaching = schoolteaching;
    }
}

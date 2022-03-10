package fr.idmc.sid.coursesmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom implements Serializable {

    @Id
    private String id;
    private int number;
    private int floor;
    private int capacity;
    private Date date;

    public Classroom(int number, int floor, int capacity){
        this.id = UUID.randomUUID().toString();
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
    }

    public boolean isFree(Date date){
        if (this.date.equals(date)){
            return false;
        }
        else{
            return true;
        }
    }
}

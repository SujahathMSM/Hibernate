package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL) // can't delete a laptop without deleting a st
    @JoinColumn(name = "laptop_id", nullable = false)
    private LaptopEntity laptopEntity;

    @OneToMany(mappedBy = "studentEntity", targetEntity = BookEntity.class)
    List<BookEntity> bookEntities;

    @ManyToMany(mappedBy = "studentEntities", targetEntity = SubjectEntity.class)
    private List<SubjectEntity> subjectEntities = new ArrayList<>();

}

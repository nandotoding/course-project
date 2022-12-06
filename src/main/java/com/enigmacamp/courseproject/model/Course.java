package com.enigmacamp.courseproject.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String title;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_file_id", referencedColumnName = "id")
    private CourseFile courseFile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_info_id", referencedColumnName = "id")
    private CourseInfo courseInfo;

    @ManyToOne
    @JoinColumn(name = "course_type_id", referencedColumnName = "id")
    private CourseType courseType;

}

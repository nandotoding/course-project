package com.enigmacamp.courseproject.service;

import com.enigmacamp.courseproject.model.Course;
import com.enigmacamp.courseproject.model.CourseFile;
import com.enigmacamp.courseproject.model.CourseInfo;
import com.enigmacamp.courseproject.model.CourseType;
import com.enigmacamp.courseproject.model.request.CourseFileRequest;
import com.enigmacamp.courseproject.repository.CourseFileRepo;
import com.enigmacamp.courseproject.repository.CourseInfoRepo;
import com.enigmacamp.courseproject.repository.CourseRepo;
import com.enigmacamp.courseproject.repository.CourseTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepo courseRepo;
    private CourseFileRepo courseFileRepo;
    private CourseInfoRepo courseInfoRepo;
    private CourseTypeRepo courseTypeRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo, CourseFileRepo courseFileRepo, CourseInfoRepo courseInfoRepo, CourseTypeRepo courseTypeRepo) {
        this.courseRepo = courseRepo;
        this.courseFileRepo = courseFileRepo;
        this.courseInfoRepo = courseInfoRepo;
        this.courseTypeRepo = courseTypeRepo;
    }

    @Override
    public void uploadMaterial(MultipartFile multipartFile) {

    }

    @Override
    public Course create(CourseFileRequest courseFileRequest) {
        Course course = new Course();
        course.setTitle(courseFileRequest.getTitle());
        course.setDescription(courseFileRequest.getDescription());

        CourseFile courseFile = new CourseFile();
        String filename = courseFileRequest.getFile().getOriginalFilename();
        courseFile.setFileLink(courseFileRepo.getPath(filename).toString());
        courseFileRepo.store(courseFileRequest.getFile());
        course.setCourseFile(courseFile);

        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setDuration(courseFileRequest.getDuration());
        courseInfo.setLevel(courseFileRequest.getLevel());
        course.setCourseInfo(courseInfo);

        CourseType courseType = new CourseType();
        courseType.setTypeName(courseFileRequest.getTypeName());
        course.setCourseType(courseType);

        courseRepo.save(course);

        return course;
    }

}

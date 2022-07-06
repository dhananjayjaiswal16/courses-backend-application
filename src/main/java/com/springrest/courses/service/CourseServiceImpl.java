package com.springrest.courses.service;

import com.springrest.courses.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CourseServiceImpl implements CourseService {
    List<Course> list;
    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(1, "React course", "Learn react in 2hrs","Javascript, reactjs"));
        list.add(new Course(2, "Nodejs course", "Learn node js with real world project",
                "Javascript, Nodejs, Express"));
    }
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c = null;
        for(Course course : list){
            if(course.getId() == courseId){
                return course;
            }
        }
        return null;
    }

    @Override
    public Course addCourse(Course course) {

        return null;
    }

    @Override
    public Course updateCourse(Course course) {

        return null;
    }

}

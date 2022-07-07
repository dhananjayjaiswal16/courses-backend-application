package com.springrest.courses.service;

import com.springrest.courses.dao.CourseRepository;
import com.springrest.courses.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
//    List<Course> list;
    @Autowired
    private CourseRepository courseRepository;
    public CourseServiceImpl(){
        /*list = new ArrayList<>();
        list.add(new Course(1, "React course", "Learn react in 2hrs","Javascript, reactjs"));
        list.add(new Course(2, "Nodejs course", "Learn node js with real world project",
                "Javascript, Nodejs, Express"));*/
    }
    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
//        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c = null;
        /*for(Course course : list){
            if(course.getId() == courseId){
                return course;
            }
        }*/
        return courseRepository.getReferenceById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
        courseRepository.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        /*list.forEach(c -> {
            if(c.getId() == course.getId()){
                if(course.getTitle() != null && course.getDescription() != null && course.getTopics() != null){
                    System.out.println("YES YES YES");
                    c.setTitle(course.getTitle());
                    c.setDescription(course.getDescription());
                    c.setTopics(course.getTopics());
                }
            }
        });*/
        courseRepository.save(course);
        return course;
    }
    public void deleteCourse(long courseId){
//        list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
        courseRepository.delete(courseRepository.getReferenceById(courseId));
    }

}

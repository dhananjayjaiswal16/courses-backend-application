package com.springrest.courses.controllers;

import com.springrest.courses.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    public CourseController() {
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){


    }
}

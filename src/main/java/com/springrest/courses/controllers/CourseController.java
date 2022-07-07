package com.springrest.courses.controllers;

import com.springrest.courses.entity.Course;
import com.springrest.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses(){
        try{
            return new ResponseEntity<>(this.courseService.getCourses(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable String courseId){
        try{
            Course course = this.courseService.getCourse(Long.parseLong(courseId));
            if(course == null){
                return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Exception in GET:/course { " + e + "}",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/course")
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        try{
            return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Exception in POST:/course { " + e + " }", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/course")
    public ResponseEntity<?> updateCourse(@RequestBody Course course){
        try{
            return new ResponseEntity<>(this.courseService.updateCourse(course), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Exception in PUT:/course { " + e + " }", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long courseId){
        try {
            this.courseService.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.springrest.courses.service;

import com.springrest.courses.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(long courseId);
}

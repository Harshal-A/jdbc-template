package com.demo.jdbc.dao;

import com.demo.jdbc.model.Course;

import java.util.List;
import java.util.Optional;

public interface DAO {

     List list();

     void create(Course course);

     Optional<Course> get(int id);

     void update(Course course, int id);

     void delete(int id);





}

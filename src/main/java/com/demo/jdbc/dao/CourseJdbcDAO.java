package com.demo.jdbc.dao;

import com.demo.jdbc.dao.rowmapper.CourseJdbcRowMapper;
import com.demo.jdbc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class CourseJdbcDAO implements DAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CourseJdbcRowMapper rowMapper;

    @Override
    public List list() {
        String sql="Select course_id,title,description,link from course";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void create(Course course) {
        String sql="Insert into course (title,description,link) values (?,?,?)";
        int numRows= jdbcTemplate.update(sql,course.getTitle(),course.getDescription(),course.getLink());
        if(numRows==1) System.out.println("New Course created : "+course.getTitle());
    }

    @Override
    public Optional get(int id) {
        String sql="Select course_id,title,description,link from course where course_id=?";
        Course course=null;
        try {
            course = (Course) jdbcTemplate.queryForObject(sql, rowMapper, id);
        }
        catch (DataAccessException ex){
            System.out.println("Course not found with id : "+id);
        }
        return Optional.ofNullable(course);
    }

    @Override
    public void update(Course course, int id) {
        String sql="update course set title=?,description=?,link=? where course_id=?";
        int numRows= jdbcTemplate.update(sql,course.getTitle(),course.getDescription(),course.getLink(),course.getCourseId());
        if(numRows==1) System.out.println("Course Updated : "+course.getTitle());
    }

    @Override
    public void delete(int id) {
        String sql="delete from course where course_id=?";
        jdbcTemplate.update(sql,id);

    }
}

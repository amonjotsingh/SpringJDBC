package com.example.pragra23apr.dao;

import com.example.pragra23apr.domain.Course;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
@Component
public class CourseDAO {

    private JdbcTemplate template;

    public CourseDAO(JdbcTemplate template) {
        this.template = template;
    }

    public boolean createCourse(Course course) {
        String sql = "INSERT INTO COURSE VALUES(?,?,?,?,?)";
        int update = template.update(sql, course.getId(), course.getCourseName(), course.getCourseFee(), course.getCreateDate(), course.getUpdateDate());
        if (update != 1) {
            return false;
        }
        return true;
    }
//    UPDATE tutorials SET title=?, description=?, published=? WHERE id=?
    public void updateCourse(Course course) {
        String sql = "UPDATE COURSE SET COURSE_NAME=?,COURSE_FEE=?,CREATE_DATE=?,UPDATE_DATE=? WHERE id=?";
        template.update(sql, course.getCourseName(), course.getCourseFee(), course.getCreateDate(), course.getUpdateDate(), course.getId());
    }

    public void deleteCourse(int id) {
        int update = template.update("DELETE FROM course WHERE id=?", id);
    }

    public List<Course> getCourses() {
        return template.query("SELECT * FROM COURSE", new BeanPropertyRowMapper<>(Course.class));
    }

}

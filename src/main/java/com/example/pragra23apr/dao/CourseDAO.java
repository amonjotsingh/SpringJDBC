package com.example.pragra23apr.dao;

import com.example.pragra23apr.domain.Course;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
@Component
public class CourseDAO {

    private NamedParameterJdbcTemplate template;

    public CourseDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public boolean createCourse(Course course) {
        String sql = "INSERT INTO COURSE VALUES(:id,:courseName,:courseFee,:createDate,:updateDate)";

        int update = template.update(sql, new BeanPropertySqlParameterSource(course));
        if (update != 1) {
            return false;
        }
        return true;
    }
//    UPDATE tutorials SET title=?, description=?, published=? WHERE id=?
    public void updateCourse(Course course) {
        String sql = "UPDATE COURSE SET COURSE_NAME=:courseName,COURSE_FEE=:courseFee,CREATE_DATE=:createDate,UPDATE_DATE=:updateDate WHERE id=:id";
        template.update(sql, new BeanPropertySqlParameterSource(course));
    }

    public void deleteCourse(Course course) {
        int update = template.update("DELETE FROM course WHERE id= :id", new BeanPropertySqlParameterSource(course.getId()));
    }

    public List<Course> getCourses() {
        return template.query("SELECT * FROM COURSE", new BeanPropertyRowMapper<>(Course.class));
    }

}

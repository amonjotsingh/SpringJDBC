package com.example.pragra23apr.dao;

import com.example.pragra23apr.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
@Component
public class StudentDAO {
    private NamedParameterJdbcTemplate template;

    public StudentDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public boolean createStudent(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(:id,:firstName,:lastName,:createDate,:updateDate)";
        int update = template.update(sql,new BeanPropertySqlParameterSource(student));
        if (update != 1) {
            return false;
        }
        return true;
    }

    public int deleteStudent(Student student) {
        return template.update("DELETE FROM STUDENT WHERE ID=:id", new BeanPropertySqlParameterSource(student.getId()));
    }

    public int updateStudent(Student student) {
        return template.update("UPDATE STUDENT SET FIRST_NAME=:firstName, LAST_NAME=:lastName, CREATE_DATE=:createDate, UPDATE_DATE=:updateDate where ID =:id"
                ,new BeanPropertySqlParameterSource(student));
    }

    public List<Student> getStudents() {
        return template.query("SELECT * FROM STUDENT", new BeanPropertyRowMapper<>(Student.class));
    }
}

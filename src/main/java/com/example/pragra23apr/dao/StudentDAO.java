package com.example.pragra23apr.dao;

import com.example.pragra23apr.domain.Student;
import lombok.AllArgsConstructor;
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
public class StudentDAO {
    private JdbcTemplate template;

    public StudentDAO(JdbcTemplate template) {
        this.template = template;
    }

    public boolean createStudent(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
        int update = template.update(sql, student.getId(), student.getFirstName(), student.getLastName(), student.getCreateDate(), student.getUpdateDate());
        if (update != 1) {
            return false;
        }
        return true;
    }

    public int deleteStudent(int id) {
        return template.update("DELETE FROM STUDENT WHERE ID=?", id);
    }

    public int updateStudent(Student student) {
        return template.update("UPDATE STUDENT SET FIRST_NAME=?, LAST_NAME=?, CREATE_DATE=?, UPDATE_DATE=? where ID =?"
                ,student.getFirstName(),student.getLastName(),student.getCreateDate(),student.getUpdateDate(),student.getId());
    }

    public List<Student> getStudents() {
        return template.query("SELECT * FROM STUDENT", new BeanPropertyRowMapper<>(Student.class));
    }
}

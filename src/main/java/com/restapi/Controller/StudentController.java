package com.restapi.Controller;

import com.restapi.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
// @RestController = @Controller + @ResponseBody
// 可以用文字回傳，而不是用resources/templates底下的html
public class StudentController {
    //可以透過 http://localhost:8080/student 來查看
    //會回傳一個學生的資訊
    @GetMapping("/student")
    //@GetMapping = @RequestMapping("/student", method = RequestMethod.GET)
    public Student getStudent(){
        Student student = new Student(
                1,
                "AAA",
                "BBB"
        );
        return student;
    }
    //可以透過 http://localhost:8080/students 來查看
    //會回傳多個學生的資訊
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "AAA", "BBB"));
        students.add(new Student(2, "CCC", "DDD"));
        students.add(new Student(3, "EEE", "FFF"));
        students.add(new Student(4, "GGG", "HHH"));
        return students;
    }
}

package com.restapi.Controller;

import com.restapi.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController = @Controller + @ResponseBody
// 可以用文字回傳，而不是用resources/templates底下的html
public class StudentController {
    //可以透過 http://localhost:8080/student 來查看
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
}

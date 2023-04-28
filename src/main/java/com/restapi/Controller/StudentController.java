package com.restapi.Controller;

import com.restapi.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    //可以透過 http://localhost:8080/students/數字/名字/姓氏 來傳入資料
    //舉例來說輸入 http://localhost:8080/students/1/AAA/BBB
    //就能看到回傳的{"id":1,"firstName":"AAA","lastName":"BBB"}
    //透過網址傳入學生的ID、firstName、lastName
    //使用@PathVariable讀取網址傳來的資料
    @GetMapping("/students/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName){
        return new Student(studentId, firstName, lastName);
    }
    //可以透過 http://localhost:8080/students/query?id=數字&firstName=名字&lastName=姓氏 來傳入資料
    //舉例來說輸入 http://localhost:8080/students/query?id=1&firstName=AAA&lastName=BBB
    //就能看到回傳的{"id":1,"firstName":"AAA","lastName":"BBB"}
    //透過網址傳入學生的ID、firstName、lastName
    //使用@RequestParam讀取網址傳來的資料
    //和@PathVariable不同，傳入的順序不限定為「id再來firstName最後是lastName」
    //換成http://localhost:8080/students/query?id=1&lastName=BBB&firstName=AAA
    //還是能取得相同的結果
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }
}

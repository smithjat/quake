package springboot_mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot_mongodb.dao.StudentRepository;
import springboot_mongodb.entity.Student;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    @ResponseBody
//    public String addStudent(){
//         Student student = new Student("1234",12);
//         mongoOperations.save(student);
//         return "SUCCEED";
//    }
    @ResponseBody
    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


}

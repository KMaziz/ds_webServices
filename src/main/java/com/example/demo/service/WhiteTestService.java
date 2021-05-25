package com.example.demo.service;

import de.tekup.soap.models.whitetest.*;
import org.springframework.stereotype.Service;
import com.example.demo.test.*;

import java.util.List;

@Service
public class WhiteTestService {


    public WhiteTestResponse checkWhiteTest(StudentRequest studentRequest) {

        WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();

        int student_id = studentRequest.getStudentId();
        String exam_code = studentRequest.getExamCode();

        test t = new test();

        List<Student> students = t.getListOfStudent();
        List<Exam> exams = t.getListOfExam();
        List<WhiteTestResponse> list = t.getListOfdata();

        boolean test_student = false;
        for (int i = 0; i <students.size() ; i++) {
            if(students.get(i).getId()==student_id)
            {
                test_student=true;
                break;
            }
        }

        if(!test_student)
            whiteTestResponse.getError().add("wrong student id");


        boolean test_exam = exams.stream().anyMatch(x->x.getCode().equals(exam_code));
        for (int i = 0; i <exams.size() ; i++) {
            if(exams.get(i).getCode().equals(exam_code)){
                test_exam=true;
                break;
            }
        }

        if(!test_exam)
            whiteTestResponse.getError().add("wrong exam code");


        if(whiteTestResponse.getError().isEmpty()){
            for (int i = 0; i <list.size() ; i++) {
                if(list.get(i).getExam().getCode().equals(exam_code) && list.get(i).getStudent().getId()==student_id){
                    return list.get(i);
                }
            }

            whiteTestResponse.getError().add("the whiteTest does not exist");
        }
        return whiteTestResponse;

    }
}

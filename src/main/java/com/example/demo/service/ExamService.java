package com.example.demo.service;

import com.example.demo.test.test;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ExamResponse;
import de.tekup.soap.models.whitetest.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

  public ExamResponse TestExam(){
      ExamResponse examResponse = new ObjectFactory().createExamResponse();
      test t = new test();
      List<Exam> exams = t.getListOfExam();
      for (int i = 0; i < exams.size(); i++) {
          if(exams.get(i).isAvailable()==true)
          {
              examResponse.getExamList().add(exams.get(i));
          }
      }

      return examResponse;

  }



}

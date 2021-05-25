package com.example.demo.test;

import de.tekup.soap.models.whitetest.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class test {
    public  List<Student> listOfStudent = new ArrayList<>();
    public  List<Exam> listOfExam = new ArrayList<>();
    public  List<WhiteTestResponse> listOfdata = new ArrayList<>();


    public test() {
        ObjectFactory of = new ObjectFactory();

        Address ad1 = of.createAddress();
        ad1.setCity("Ariana");
        ad1.setPostCode(2080);
        ad1.setStreet("Rue habib bourguiba");

        Address ad2 = of.createAddress();
        ad2.setCity("tunis");
        ad2.setPostCode(5555);
        ad2.setStreet("Rue habib bourguiba");


        Student s1 = of.createStudent();
        s1.setId(1);
        s1.setName("Aziz");
        s1.setAddress(ad1);

        Student s2 = of.createStudent();
        s2.setId(2);
        s2.setName("Ali");
        s2.setAddress(ad1);

        Student s3 = of.createStudent();
        s3.setId(3);
        s3.setName("Ali 2");
        s3.setAddress(ad2);

        listOfStudent.add(s1);
        listOfStudent.add(s2);
        listOfStudent.add(s3);

        Exam e1 = of.createExam();
        e1.setCode("1z0-808");
        e1.setName("OCA");
        e1.setAvailable(true);

        Exam e2 = of.createExam();
        e2.setCode("1z0-809");
        e2.setName("OCP");
        e2.setAvailable(true);

        Exam e3 = of.createExam();
        e3.setCode("aws");
        e3.setName("AWS");
        e3.setAvailable(true);

        listOfExam.add(e1);
        listOfExam.add(e2);
        listOfExam.add(e3);

        XMLGregorianCalendar xmlGregorianCalendar1=null;
        XMLGregorianCalendar xmlGregorianCalendar2=null;
        XMLGregorianCalendar xmlGregorianCalendar3=null;
        try {
            xmlGregorianCalendar1 =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar();

            xmlGregorianCalendar2 =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar();

            xmlGregorianCalendar3 =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        if(xmlGregorianCalendar1 != null){
            WhiteTestResponse wt1 = of.createWhiteTestResponse();
            wt1.setStudent(s1);
            wt1.setExam(e1);
            xmlGregorianCalendar1.setYear(2020);
            xmlGregorianCalendar1.setTime(16,30,12);
            xmlGregorianCalendar1.setDay(20);
            xmlGregorianCalendar1.setMonth(4);
            wt1.setDate(xmlGregorianCalendar1);
            listOfdata.add(wt1);
        }

        if(xmlGregorianCalendar2 != null){
            WhiteTestResponse wt2 = of.createWhiteTestResponse();
            wt2.setStudent(s2);
            wt2.setExam(e2);
            xmlGregorianCalendar2.setYear(2016);
            xmlGregorianCalendar2.setTime(12,50,5);
            xmlGregorianCalendar2.setDay(16);
            xmlGregorianCalendar2.setMonth(8);
            wt2.setDate(xmlGregorianCalendar2);
            listOfdata.add(wt2);
        }

        if(xmlGregorianCalendar3 != null){
            WhiteTestResponse wt3 = of.createWhiteTestResponse();
            wt3.setStudent(s3);
            wt3.setExam(e3);
            xmlGregorianCalendar3.setYear(2021);
            xmlGregorianCalendar3.setTime(12,20,5);
            xmlGregorianCalendar3.setDay(30);
            xmlGregorianCalendar3.setMonth(8);
            wt3.setDate(xmlGregorianCalendar3);
            listOfdata.add(wt3);
        }
    }

    public  List<WhiteTestResponse> getListOfdata() {
        return listOfdata;
    }

    public  void setListOfdata(List<WhiteTestResponse> listOfdata) {
        this.listOfdata = listOfdata;
    }

    public List<Student> getListOfStudent() {
        return listOfStudent;
    }

    public void setListOfStudent(List<Student> listOfStudent) {
        this.listOfStudent = listOfStudent;
    }

    public List<Exam> getListOfExam() {
        return listOfExam;
    }

    public void setListOfExam(List<Exam> listOfExam) {
        this.listOfExam = listOfExam;
    }
}

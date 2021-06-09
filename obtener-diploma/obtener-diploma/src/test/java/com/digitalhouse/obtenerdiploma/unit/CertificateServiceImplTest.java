package com.digitalhouse.obtenerdiploma.unit;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CertificateServiceImplTest {
    @Autowired
    CertificateServiceImpl certificateService;
    @Test
    public void shouldPassStudentWithHonors(){
        //arrange
        StudentDTO student = createStudentWithHighAverage();
        CertificateDTO certificate = new CertificateDTO(student);
        double expectedAverage = 9.5;
        String expectedMessage = "¡Felicitaciones " + student.getName() + "! Usted tiene el gran promedio de " + expectedAverage;

        certificate.setAverage(expectedAverage);
        certificate.setMessage(expectedMessage);

        //act
        CertificateDTO testingCertificate = certificateService.analyzeNotes(student);

        //assert
        assertEquals(expectedAverage,testingCertificate.getAverage());
        assertEquals(expectedMessage,testingCertificate.getMessage());
    }

    @Test
    public void shouldAnalyzeStudentWithoutHonors(){
        StudentDTO student = createStudentWithAverage8();
        CertificateDTO certificate = new CertificateDTO(student);
        double expectedAverage = 8;
        String expectedMessage = student.getName() + " usted ha conseguido el promedio de " + expectedAverage;

        certificate.setAverage(expectedAverage);
        certificate.setMessage(expectedMessage);

        //act
        CertificateDTO testingCertificate = certificateService.analyzeNotes(student);

        //assert
        assertEquals(expectedAverage,testingCertificate.getAverage());
        assertEquals(expectedMessage,testingCertificate.getMessage());


    }

    private StudentDTO createStudentWithHighAverage(){
        SubjectDTO subject1 = new SubjectDTO("historia",9);
        SubjectDTO subject2 = new SubjectDTO("geografia",10);

        List<SubjectDTO> subjectsList = new ArrayList<>();
        subjectsList.add(subject1);
        subjectsList.add(subject2);

        StudentDTO student = new StudentDTO("MarcioSantana",subjectsList);
        return student;
    }

    private StudentDTO createStudentWithAverage8(){
        SubjectDTO subject1 = new SubjectDTO("historia",10);
        SubjectDTO subject2 = new SubjectDTO("geografia",6);

        List<SubjectDTO> subjectsList = new ArrayList<>();
        subjectsList.add(subject1);
        subjectsList.add(subject2);

        StudentDTO student = new StudentDTO("MarcioSantana",subjectsList);
        return student;
    }
}

package com.digitalhouse.obtenerdiploma;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CertificateServiceImplTest {
  @Autowired
  private CertificateServiceImpl certificateService;

  @Test
  void shouldReturnTheCertificateWithMessageAverageAndStudent(){
    StudentDTO studentDTO = createStudentDTO();
    String expectedMessage = studentDTO.getName() + " usted ha conseguido el promedio de 8.0";
    CertificateDTO expected =
            new CertificateDTO(expectedMessage, 8.0, studentDTO);

    CertificateDTO result = certificateService.analyzeNotes(studentDTO) ;

    assertEquals(result, expected);
  }

  @Test
  void shouldReturnTheCertificateWithHonorsWhenAverageIsGreaterThan9(){
    StudentDTO studentDTO = createStudentDTOWithAverageTen();
    String expectedMessage = "¡Felicitaciones Gustavo Hsu Wu! Usted tiene el gran promedio de 10.0";
    CertificateDTO expected =
            new CertificateDTO(expectedMessage, 10.0, studentDTO);

    CertificateDTO result = certificateService.analyzeNotes(studentDTO) ;

    assertEquals(result, expected);
  }

  @Test
  void shouldReturnTheAverageOfNotes(){
    StudentDTO studentDTO = createStudentDTO();
    Double expected = 8.0;

    Double result = certificateService.calculateAverage(studentDTO);

    assertEquals(result, expected);
  }

  @Test
  void shouldReturnTheDiplomaMessage(){
    StudentDTO studentDTO = createStudentDTO();
    String expected = studentDTO.getName() + " usted ha conseguido el promedio de 8.0";

    String result = certificateService.writeDiploma(studentDTO);

    assertEquals(result, expected);
  }

  @Test
  void shouldReturnTheDiplomaWithHonor(){
    StudentDTO studentDTO = createStudentDTOWithAverageTen();
    String name = studentDTO.getName();
    String expected = "¡Felicitaciones " + name + "! Usted tiene el gran promedio de " + 8.0;

    String result = certificateService.withHonors(8.0, name);

    assertEquals(result, expected);
  }

  private StudentDTO createStudentDTO() {
    StudentDTO studentDTO = new StudentDTO();

    studentDTO.setName("Gustavo Hsu Wu");

    SubjectDTO subjectDTO = new SubjectDTO("disciplina1", 7);
    SubjectDTO subjectDTO2 = new SubjectDTO("disciplina2", 9);
    List<SubjectDTO> subjects = new ArrayList<>();
    subjects.add(subjectDTO);
    subjects.add(subjectDTO2);

    studentDTO.setSubjects(subjects);

    return studentDTO;
  }

  private StudentDTO createStudentDTOWithAverageTen() {
    StudentDTO studentDTO = new StudentDTO();

    studentDTO.setName("Gustavo Hsu Wu");

    SubjectDTO subjectDTO = new SubjectDTO("disciplina1", 10);
    List<SubjectDTO> subjects = new ArrayList<>();
    subjects.add(subjectDTO);

    studentDTO.setSubjects(subjects);

    return studentDTO;
  }

}

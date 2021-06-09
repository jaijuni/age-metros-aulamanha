package com.digitalhouse.obtenerdiploma.dto;

import java.util.Objects;

public class CertificateDTO{
  private String message;
  private Double average;
  private StudentDTO student;

  public CertificateDTO() {
  }

  public CertificateDTO(StudentDTO student) {
    this.student = student;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Double getAverage() {
    return average;
  }

  public void setAverage(Double average) {
    this.average = average;
  }

  public StudentDTO getStudent() {
    return student;
  }

  public void setStudent(StudentDTO student) {
    this.student = student;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CertificateDTO that = (CertificateDTO) o;
    return Objects.equals(message, that.message) && Objects.equals(average, that.average) && Objects.equals(student, that.student);
  }
}

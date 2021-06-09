package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;


public class SubjectDTO {
  @NotNull(message = "The name cannot be null")
  @Pattern(regexp = "^[a-zA-Z -,.']+$")
  @Size(min=8, max = 50)
  private String subject;

  @NotNull(message = "The note cannot be null")
  @Max(value=10)
  @Min(value=0)
  private Integer note;

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }

}

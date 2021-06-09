package com.digitalhouse.obtenerdiploma.util.builder;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;

public class StudentDTOBuilder {

    private StudentDTO studentDTO = new StudentDTO();

    public void withName(String name) {
        this.studentDTO.setName(name);
    }

    public StudentDTO build() {
        return this.studentDTO;
    }

}
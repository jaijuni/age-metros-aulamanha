package br.com.digitalhouse.FirstProject.controllers;

import br.com.digitalhouse.FirstProject.dtos.AgeDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/")
public class FirstController {

    @GetMapping
    public List<AgeDTO> cumprimento() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:ages.json");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<AgeDTO>> typeRef = new TypeReference<List<AgeDTO>>() {};
        List<AgeDTO> ageDTOS = null;
        try {
            ageDTOS = objectMapper.readValue(file, typeRef);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ageDTOS;
    }

}

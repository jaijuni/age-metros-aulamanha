package br.com.digitalhouse.FirstProject.controllers;

import br.com.digitalhouse.FirstProject.dtos.AgeDTO;
import br.com.digitalhouse.FirstProject.dtos.DateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RequestMapping("/age")
@RestController
public class AgeCalculatorController {

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<AgeDTO> getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        DateDTO date = new DateDTO();
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);

        Integer age = calculateAge(date);

        AgeDTO ageDTO = new AgeDTO();
        ageDTO.setAge(age);
        ageDTO.setDate(day + "/" + month + "/" + year);

        return new ResponseEntity<>(ageDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AgeDTO> ageByPost(@RequestBody DateDTO date) {
        Integer age = calculateAge(date);
        AgeDTO ageDTO = new AgeDTO();
        ageDTO.setAge(age);
        ageDTO.setDate(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
        return new ResponseEntity<>(ageDTO, HttpStatus.OK);
    }

    private Integer calculateAge(DateDTO date) {
        Period age;
        try {
            LocalDate birth = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
            age = Period.between(birth, LocalDate.now());
            return age.getYears();
        }
        catch (Exception e) {
            return 0;
        }
    }
}

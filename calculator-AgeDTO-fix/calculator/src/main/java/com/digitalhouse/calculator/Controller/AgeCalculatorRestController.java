package com.digitalhouse.calculator.Controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeCalculatorRestController {
    @GetMapping("/{day}/{month}/{year}")
    @ResponseBody
    public String getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return this.calculateAge(day,month,year);
    }

    private String calculateAge(Integer day,Integer month, Integer year) {
        Period age;
        try {
            LocalDate date = LocalDate.of(year,month,day);
            age = Period.between(date, LocalDate.now());
            return age.getYears() + "";
        } catch (Exception e){
            return "0";
        }
    }
}

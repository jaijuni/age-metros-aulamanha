package br.com.digitalhouse.FirstProject.controllers;

import br.com.digitalhouse.FirstProject.dtos.PriceDTO;
import br.com.digitalhouse.FirstProject.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class MetrosQuadradosController {
    @Autowired
    PriceRepository priceRepository;

    @GetMapping("/{location}")
    public PriceDTO getPriceByLocation(@PathVariable String location) {
        return priceRepository.findPriceByLocation(location);
    }
}

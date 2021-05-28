package br.com.digitalhouse.FirstProject.repositories;

import br.com.digitalhouse.FirstProject.dtos.PriceDTO;
import org.springframework.stereotype.Repository;


public interface PriceRepository {
    PriceDTO findPriceByLocation(String location);
}

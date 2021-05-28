package br.com.digitalhouse.FirstProject.repositories;

import br.com.digitalhouse.FirstProject.dtos.PriceDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
    @Override
    public PriceDTO findPriceByLocation(String location) {
        List<PriceDTO> priceDTOS = loadDataBase();
        PriceDTO result = null;
        if(priceDTOS != null) {
            Optional<PriceDTO> item = priceDTOS.stream()
                    .filter(priceDTO -> priceDTO.getLocation().equals(location))
                    .findFirst();
            if(item.isPresent()) {
                result = item.get();
            }
        }
        return result;
    }

    private List<PriceDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:price.json");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PriceDTO>> typeRef = new TypeReference<List<PriceDTO>>() {};
        List<PriceDTO> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }
}

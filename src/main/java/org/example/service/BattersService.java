package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.example.dto.BatterType;
import org.example.dto.Batters;
import org.example.dto.Flavors;
import org.example.dto.ResponseFlavors;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BattersService {

    public List<Flavors> searchBatters(String batter) {
        List<Flavors> flavorsList = null;
        try {
            ClassPathResource resource = new ClassPathResource("BattersJson.json");
            File file = resource.getFile();
            String content = new String(Files.readAllBytes(file.toPath()));
            ObjectMapper mapper = new ObjectMapper();
            ResponseFlavors flavors =mapper.readValue(content, ResponseFlavors.class);
           /* ResponseFlavors flavors =mapper.readValue(content,
                    mapper.getTypeFactory().constructCollectionType(List.class, ResponseFlavors.class));*/
            flavorsList = flavors.getFlavorsList().stream()
                    .filter(fla -> fla.getBatters().getBatter()
                            .stream().anyMatch(bat -> bat.getType().equals(batter))).collect(Collectors.toList());
            log.info(content);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return flavorsList;
    }
}

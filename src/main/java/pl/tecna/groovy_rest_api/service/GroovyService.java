package pl.tecna.groovy_rest_api.service;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.tecna.groovy_rest_api.infrastructure.GroovyDto;

@Service
@AllArgsConstructor
public class GroovyService {

    private final RestTemplate restTemplate;

    private final String crudResourceUrl = "";

    public boolean delete(String scriptName) {
        return false;
    }

    public void persistGroovyEntity(GroovyDto groovyDto) {
    }

    public GroovyDto getScriptByName(String name){
        return restTemplate.getForObject(
                "tecna-groovy-data-service/groovy/" + name, GroovyDto.class);
    }
}

package pl.tecna.groovy_rest_api.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import pl.tecna.groovy_rest_api.infrastructure.GroovyDto;

@Service
@AllArgsConstructor
public class GroovyService {

    private final RestTemplate restTemplate;

    private final WebClient.Builder webClientBuilder;

    private final String crudOpsServiceUrl = "http://tecna-groovy-data-service/groovy/";

    public boolean delete(String scriptName) {
        return false;
    }


    public String deleteByName(String name) {
        return webClientBuilder.build()
                .delete()
                .uri(crudOpsServiceUrl+name)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public ResponseEntity<String> saveGroovyScript(@RequestBody GroovyDto dto){
        return webClientBuilder.build()
                .post()
                .uri(crudOpsServiceUrl)
                .body(dto)
                .
    }

//    @PostMapping("/{groovyDto}")
//    @ResponseBody
//    public ResponseEntity<String> saveGroovyScript(@RequestBody GroovyDto groovyDto){
//        if(scriptService.containsScript(groovyDto.getScriptName())){
//            return new ResponseEntity<>("Script with name " + groovyDto.getScriptName() + " is already persisted", HttpStatus.OK);
//        }
//        scriptService.saveScript(groovyDto);
//        return new ResponseEntity<>("Script persisted: " + groovyDto.getScriptName(), HttpStatus.OK);
//    }

}

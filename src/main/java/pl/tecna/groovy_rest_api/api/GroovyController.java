package pl.tecna.groovy_rest_api.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import pl.tecna.groovy_rest_api.infrastructure.GroovyDto;
import pl.tecna.groovy_rest_api.service.GroovyService;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GroovyController {

    private final GroovyService groovyService;

    private final WebClient.Builder webClient;

    private final String crudOpsServiceUrl = "http://tecna-groovy-data-service/groovy/";

    @GetMapping("/{name}")
    @ResponseBody
    public ResponseEntity<String> getScriptResult(@PathVariable String name){
        return new ResponseEntity<>("inside rest api service" + name, HttpStatus.OK);
    }

    @PostMapping("/{groovyDto}")
    @ResponseBody
    public ResponseEntity<GroovyDto> createGroovyEntity(@RequestBody GroovyDto groovyDto){
        GroovyDto dto = webClient.build().post().uri(crudOpsServiceUrl).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(groovyDto), GroovyDto.class).retrieve().bodyToMono(GroovyDto.class).block();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

//    @GetMapping("/groovy/{name}")
//    @ResponseBody
//    public ResponseEntity<Page<GroovyDto>> get(GroovyScriptPage page){
//        Page<GroovyDto> result = groovyService.getScripts(page);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

//    @PostMapping("/{groovyDto}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<GroovyDto> createGroovyEntity(@RequestBody GroovyDto groovyDto) {
//        groovyService.persistGroovyEntity(groovyDto);
//        System.out.println("created new user");
//        return new ResponseEntity<>(groovyDto, HttpStatus.OK);
//    }

    @DeleteMapping("/{name}")
    @ResponseBody
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
//        if(groovyService.getScriptByName(name)==null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        groovyService.deleteByName(name);
        return new ResponseEntity<>(String.format("Groovy script: %s has beed deleted.", name), HttpStatus.OK);
    }
}

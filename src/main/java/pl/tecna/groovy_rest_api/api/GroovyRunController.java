package pl.tecna.groovy_rest_api.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tecna.groovy_rest_api.service.GroovyService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GroovyRunController {

    private GroovyService groovyService;

    @GetMapping("/groovyrunner/{name}")
    @ResponseBody
    public ResponseEntity<String> runScriptByName(@PathVariable String name){
        if(name.equals("gienek"))
            return new ResponseEntity<>("hello from the groovyrunner api, " + name, HttpStatus.OK);

        return new ResponseEntity<>("avesatan" + name, HttpStatus.OK);
    }


}

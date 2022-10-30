package pl.tecna.groovy_rest_api.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tecna.groovy_rest_api.infrastructure.GroovyDto;
import pl.tecna.groovy_rest_api.service.GroovyService;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GroovyController {

    private final GroovyService groovyService;

    @GetMapping("/groovy/{name}")
    @ResponseBody
    public ResponseEntity<GroovyDto> get(@PathVariable String name){
        GroovyDto result = groovyService.getScriptByName(name);
        return new ResponseEntity<GroovyDto>(
                groovyService.getScriptByName(name), HttpStatus.OK);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroovyEntity(@RequestBody GroovyDto groovyDto) {
        groovyService.persistGroovyEntity(groovyDto);
        System.out.println("created new user");
    }

//    @GetMapping(value = "/groovy/")
//    @ResponseBody
//    public ResponseEntity<List<GroovyDto>>
//
//
//
//    @DeleteMapping(value = "/groovy/{name}")
//    @ResponseBody
//    public ResponseEntity<String> deleteByScriptName(@PathVariable String name){
//
//        var isDeleted = groovyService.delete(name);
//
//        if(!isDeleted) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        return new ResponseEntity<>(name, HttpStatus.OK);
//    }
}

/*

@DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

        var isRemoved = postService.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{email}")
    @ResponseBody
    public ResponseEntity<UserDto> getUserByLoginPath(@PathVariable String email) throws EntityNotFoundException {
        return new ResponseEntity<>(userService.getUserByLogin(email), HttpStatus.OK);
    }

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto userDto) throws UserExistsException, InvalidEmailFormatException {
        userService.createUser(userDto);
        System.out.println("created new user");
    }
}

 */
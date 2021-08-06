package com.rizqi.springboot.api;

import com.rizqi.springboot.model.Person;
import com.rizqi.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void insertPerson(@RequestBody Person person){
        personService.insertPerson(person);
    }

    @GetMapping
    public List<Person> selectPersons(){
        return personService.selectPersons();
    }

}

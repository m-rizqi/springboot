package com.rizqi.springboot.api;

import com.rizqi.springboot.model.Person;
import com.rizqi.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping(path = "{id}")
    public Person selectPersonById(@PathVariable("id") UUID id){
        return  personService.selectPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@RequestBody Person person,@PathVariable UUID id){
        personService.updatePerson(id, person);
    }

}

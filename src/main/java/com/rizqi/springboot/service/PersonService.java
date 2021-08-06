package com.rizqi.springboot.service;

import com.rizqi.springboot.dao.PersonDao;
import com.rizqi.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return personDao.insertPerson(person);
    }

    public List<Person> selectPersons(){
        return personDao.selectPersons();
    }

}

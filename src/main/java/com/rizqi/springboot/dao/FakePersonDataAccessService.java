package com.rizqi.springboot.dao;

import com.rizqi.springboot.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectPersons() {
        return DB;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personOptional = selectPersonById(id);
        if (personOptional.isEmpty()){
            return 0;
        }
        DB.remove(personOptional.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int indexPersonUpdate = DB.indexOf(p);
            if (indexPersonUpdate >= 0){
                DB.set(indexPersonUpdate, new Person(id, person.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
}

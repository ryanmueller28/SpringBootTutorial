package com.example.SpringTutorial.dao;


import com.example.SpringTutorial.model.Person;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("personDao")
public class PersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getFirstName(), person.getLastName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personThere = selectPersonById(id);

        if (personThere.isEmpty()){
            return 0;
        }
        DB.remove(personThere.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {

        /**
         * If it exists, return 1,
         * else return 0,
         * or return 0 if nothing is there
         */
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if (indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, person.getFirstName(), person.getLastName()));
                        return 1;
                    }else{
                        return 0;
                    }
                })
                .orElse(0);


    }
}

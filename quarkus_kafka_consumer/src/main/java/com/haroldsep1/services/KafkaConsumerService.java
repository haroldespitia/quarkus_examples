package com.haroldsep1.services;

import com.haroldsep1.entities.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class KafkaConsumerService {
    
    private List<Person> people = new ArrayList<>();
    
    public String addPerson(Person person) {
        if (person.getAge() > 100) {
            return null;
        }
        people.add(person);
        return people.toString();
    }
    
    public List<Person> getPeople() {
        return people;
    }
}

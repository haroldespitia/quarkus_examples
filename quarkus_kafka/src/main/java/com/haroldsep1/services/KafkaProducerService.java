package com.haroldsep1.services;

import com.haroldsep1.dto.Response;
import com.haroldsep1.entities.Person;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class KafkaProducerService {
    
    private final List<Long> people = new ArrayList<>();
    
    @Inject
    @Channel("register-person")
    Emitter<Person> personEmitter;
    
    public Response addPersonToList(Person person) {
        if (findPersonIdInList(person.getId()) != null) {
            return new Response("Person already exists in people");
        }
        if (person.getAge() < 18) {
            return new Response("Person must me major age");
        }
        people.add(person.getId());
        personEmitter.send(Message.of(person));
        
        return new Response("Person added successfully");
    }
    
    private Long findPersonIdInList(Long personId) {
        return this.people.stream().filter(item -> item.equals(personId)).findAny().orElse(null);
    }
}

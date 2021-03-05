package com.haroldsep1.controllers;

import com.haroldsep1.entities.Person;
import com.haroldsep1.services.KafkaConsumerService;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

@GraphQLApi
@ApplicationScoped
public class KafkaConsumer {
    
    @Inject
    KafkaConsumerService kafkaConsumerService;
    
    @Incoming("people")
    public CompletionStage<Void> processSavePerson(Message<Person> person) {
        String response = kafkaConsumerService.addPerson(person.getPayload());
        if (response == null) {
            return person.nack(new Throwable("Person is over hundred years old"));
        }
        System.out.println("-----------------------------------------------------");
        System.out.println(response);
        System.out.println("-----------------------------------------------------");
        return person.ack();
    }
    
    
    @Query("getAllPeople")
    public List<Person> getAllPeople() {
        return kafkaConsumerService.getPeople();
    }
    
}

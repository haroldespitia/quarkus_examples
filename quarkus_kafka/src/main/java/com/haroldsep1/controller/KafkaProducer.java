package com.haroldsep1.controller;

import com.haroldsep1.dto.Response;
import com.haroldsep1.entities.Person;
import com.haroldsep1.services.KafkaProducerService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;

@GraphQLApi
public class KafkaProducer {
    
    @Inject
    KafkaProducerService kafkaProducerService;
    
    @Query("addPersonToPeople")
    @Description("Algo")
    public Response addPersonToPeople(@Name("personId") Integer personId,
                                      @Name("fullName") String fullName,
                                      @Name("age") Integer age) {
        Person person = new Person();
        person.setId(personId.longValue());
        person.setFullName(fullName);
        person.setAge(age.shortValue());
        return kafkaProducerService.addPersonToList(person);
    }
}
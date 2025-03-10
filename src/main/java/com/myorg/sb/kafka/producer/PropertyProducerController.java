package com.myorg.sb.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myorg.sb.kafka.model.Property;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PropertyProducerController {

    private final PropertyProducerService service;

    public PropertyProducerController(PropertyProducerService service) {
        this.service = service;
    }

    @PostMapping(value="/publish", consumes="application/json")
    public ResponseEntity<Void> publishMessage(@RequestBody Property property) throws JsonProcessingException {
        service.publishMessage(property);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

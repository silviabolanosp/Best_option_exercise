package com.example.dhl.controller;

import com.example.dhl.entity.Output;
import com.example.dhl.service.OutputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class OutputController {

    private final OutputService service;
    public OutputController(OutputService service) {
        this.service = service;
    }
    Logger logger = LoggerFactory.getLogger(OutputController.class);
    /**
     * Default error message.
     */
    private static final String ERROR_500 = "500 Internal Server Error[";



    @GetMapping("/getPastOutputs")
    public ResponseEntity<Object> getPastOutputs() {
        logger.info("controller /getPastOutputs {\"\": \"\"} ");
        try {
            Optional<List<Output>> outputs =
                    service
                            .getPastOutputs();
            if (outputs.isPresent() && !outputs.get().isEmpty()) {
                return ResponseEntity
                        .ok(outputs.get());
            }
            return ResponseEntity.ok(Collections.emptyList());
        } catch (Exception ex) {
            return ResponseEntity
                    .internalServerError()
                    .body(ERROR_500 + ex + "]");
        }
    }

    @PostMapping("/calculate")
    public ResponseEntity<Object> calculate(
            @RequestParam(value = "units") Integer units,
            @RequestParam(value = "hours") Integer hours
    ) {
        logger.info("controller /calculate {\"\": \"\"} ");
        try {
            List<Output> outputs =
                    service.calculate(units, hours);

            return ResponseEntity
                    .ok(outputs);

        } catch (Exception ex) {
            return ResponseEntity
                    .internalServerError()
                    .body(ERROR_500 + ex + "]");
        }
    }


}

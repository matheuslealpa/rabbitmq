package br.com.matheusleal.produce.app.rest;

import br.com.matheusleal.produce.app.service.StringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/string")
@RequiredArgsConstructor
public class StringRest {

    private final StringService service;

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam String message) {
        service.produce(message);
        return ResponseEntity.ok().body("Sending message: " + message);
    }

}

package org.example.controller;

import org.example.dto.Batters;
import org.example.dto.Flavors;
import org.example.service.BattersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/batters")
public class BattersController {
    @Autowired
    private BattersService service;

    @GetMapping(value = "/search/{searchBatter}", produces = "Application/json")
    public ResponseEntity<Object> getBatters(@PathVariable String searchBatter) {

        List<Flavors> flavors = service.searchBatters(searchBatter);
        return ResponseEntity.ok(flavors);
    }

}

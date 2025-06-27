package com.reminder.reminder.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository runRepo;

    public RunController(RunRepository runRepo) {
        this.runRepo = runRepo;
    }

    // get
    @GetMapping("")
    List<Run> findAll() {
        return runRepo.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepo.findById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Runs not found!");
        }
        return run.get();
    }

    @GetMapping("/miles" + "{miles}")
    Run findByTitle(@PathVariable Integer miles) {
        Optional<Run> run = runRepo.findByMiles(miles);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Runs not found!");
        }
        return run.get();
    }

    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void create(@RequestBody Run run) {
        runRepo.create(run);
    }

    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id) {
        runRepo.update(run, id);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("delete/{id}")
    void delete(@PathVariable Integer id) {
        runRepo.delete(id);
    }

}

package com.reminder.reminder.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    Optional<Run> findByMiles(Integer miles) {
        return runs.stream().filter(run -> run.miles() == miles).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existRun = findById(id);
        if (existRun.isPresent()) {
            runs.set(runs.indexOf(existRun.get()), run);
        }

    }

    void delete(Integer id) {

        runs.removeIf(run -> run.id().equals(id));

    }

    @PostConstruct
    private void init() {
        runs.add(new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plusHours(5), 20));
        runs.add(new Run(3, "Third night run", LocalDateTime.of(25, 6, 22, 1, 0, 0),
                LocalDateTime.of(25, 6, 22, 6, 0, 0), 5));

    }

}

package org.top.resortsonetable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.top.resortsonetable.model.Resorts;
import org.top.resortsonetable.model.ResortsRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ResortsRepository resortsRepository;
    @GetMapping("/ping")
    public String index(){ return "pong";}
    @PostMapping("/resorts")
    public Resorts add(@RequestBody Resorts newResorts){
        return resortsRepository.save(newResorts);
    }
    @GetMapping("/resorts")
    public Iterable<Resorts> all(){ return resortsRepository.findAll();}
    @GetMapping("/resorts/{id}")
    public Optional<Resorts> getId(@PathVariable Integer id){
        return resortsRepository.findById(id);
    }
    @DeleteMapping("/resorts/{id}")
    public Optional<Resorts> delete(@PathVariable Integer id){
        Optional<Resorts> deleted = resortsRepository.findById(id);
        if (deleted.isPresent()) {
            resortsRepository.deleteById(id);
            return deleted;
        }
        return Optional.empty();
    }
    @PatchMapping("/resorts")
    public Optional<Resorts> update(@RequestBody Resorts changedResorts){
        if (changedResorts.getId() == null) { return Optional.empty();}
        Optional<Resorts> updated =
                resortsRepository.findById(changedResorts.getId());
        if (updated.isPresent()) {
            resortsRepository.save(changedResorts);
            return Optional.of(changedResorts);
        }
        return Optional.empty();
    }
}

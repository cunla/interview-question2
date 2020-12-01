package com.example.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermutationController {

    private static int nextId = 1;
    private Map<Integer, List<Integer>> data = new HashMap<>();

    @GetMapping("/store")
    public String store(@RequestParam(name = "numbers", required = true) List<Integer> numbers) {
        int id = nextId;
        nextId++;
        data.put(id, numbers);
        return String.valueOf(id);
    }

    @GetMapping("/permutation")
    public List<Integer> permutation(@RequestParam(name = "id", required = true) Integer id) {
        List<Integer> numbers = data.get(id);
        Collections.shuffle(numbers);
        return numbers;
    }
}

package com.example.cardatabase2.web;

import com.example.cardatabase2.domain.Car;
import com.example.cardatabase2.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCar(){
        // 자동차를 검색하고 나서 반환
        return repository.findAll();
    }
}

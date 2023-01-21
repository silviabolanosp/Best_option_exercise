package com.example.dhl.service;

import com.example.dhl.entity.Output;

import java.util.List;
import java.util.Optional;

public interface OutputService {
    Optional<List<Output>> getPastOutputs();

    List<Output> calculate(Integer units, Integer hours);
}

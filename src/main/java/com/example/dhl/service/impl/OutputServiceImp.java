package com.example.dhl.service.impl;

import com.example.dhl.entity.Output;
import com.example.dhl.entity.enums.CAPACITY;
import com.example.dhl.entity.enums.REGION;
import com.example.dhl.repository.OutputRepository;
import com.example.dhl.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OutputServiceImp implements OutputService {

    /**
     * Dependency injection of PersonEntityRepository to cache data.
     */
    @Autowired
    private OutputRepository outputRepository;

    private Map<CAPACITY, Double> NY_DATA = new HashMap<>();

    {
        NY_DATA.put(CAPACITY.LARGE, 120.0);
        NY_DATA.put(CAPACITY.X_LARGE, 230.0);
        NY_DATA.put(CAPACITY.X2_LARGE, 450.0);
        NY_DATA.put(CAPACITY.X4_LARGE, 774.0);
        NY_DATA.put(CAPACITY.X8_LARGE, 1400.0);
        NY_DATA.put(CAPACITY.X10_LARGE, 2820.0);
    }



    /**
     * Send data store in data base.
     * @return Optional<List<Output>>
     */
    @Override
    public Optional<List<Output>> getPastOutputs() {
        List<Output> outputs =
                outputRepository
                        .findAll();
        return Optional
                .of(outputs);
    }

    /**
     * Send data store in data base.
     * @return Optional<List<Output>>
     */
    @Override
    public List<Output> calculate(Integer units, Integer hours) {
        Output output = new Output();
        output.setRegion(REGION.NEY_YORK);
        Map<CAPACITY, Double> pricePerUnit = new HashMap<>();
        NY_DATA.forEach((key, value) -> {
            pricePerUnit.put(key, Output.calculateRatio(key, value));
        });

        List<Map.Entry<CAPACITY, Double>> nlist = new ArrayList<>(pricePerUnit.entrySet());

        nlist.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        System.out.println(nlist);

        System.out.println(output);

        for(int x = 0; units > 0; x++){
            var entry = nlist.get(x);
            while(units >= entry.getValue()){

            }
        }




        System.out.println(pricePerUnit);

        return null;
    }

}

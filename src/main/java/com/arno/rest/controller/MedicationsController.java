package com.arno.rest.controller;

import com.arno.rest.dto.MedicationsDto;
import com.arno.service.MedicationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class MedicationsController {

    private final MedicationsService medicationsService;

    @GetMapping("/medications")
    public List<MedicationsDto> getAllMedications(){
        return medicationsService.getAll().stream().map(MedicationsDto::toDto).collect(Collectors.toList());
    }
}

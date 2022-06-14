package com.arno.rest.controller;

import com.arno.rest.dto.ObjectivelyDto;
import com.arno.service.ObjectivelyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class ObjectivelyController {

    private final ObjectivelyService objectivelyService;

    @GetMapping("/objectively")
    public List<ObjectivelyDto> getAllObjectively(){
        return objectivelyService.getAll().stream().map(ObjectivelyDto::toDto).collect(Collectors.toList());
    }
}

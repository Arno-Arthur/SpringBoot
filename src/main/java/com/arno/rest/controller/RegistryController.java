package com.arno.rest.controller;

import com.arno.rest.dto.RegistryDto;
import com.arno.service.RegistryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class RegistryController {

    private RegistryService registryService;

    @GetMapping("/registry")
    public List<RegistryDto> getAllRegistry(){
        return registryService.getAll().stream().map(RegistryDto::toDto).collect(Collectors.toList());
    }
}

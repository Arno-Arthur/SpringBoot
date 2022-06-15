package com.arno.rest.controller;

import com.arno.rest.dto.RegistryDto;
import com.arno.rest.dto.ResponseDto;
import com.arno.service.RegistryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class RegistryController {

    private RegistryService registryService;

    @PostMapping("/registry/upload")
    public ResponseDto upload(@RequestBody RegistryDto registryDto){
        // Work in progress...
        //
        return new ResponseDto("Список успешно сохранен на сервере", 100);
    }
}

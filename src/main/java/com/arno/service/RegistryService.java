package com.arno.service;

import com.arno.dao.RegistryDao;
import com.arno.domain.Registry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistryService {

    private final RegistryDao registryDao;

    public List<Registry> getAll(){
        return registryDao.findAll();
    }
}

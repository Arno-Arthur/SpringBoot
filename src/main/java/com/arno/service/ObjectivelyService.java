package com.arno.service;

import com.arno.dao.ObjectivelyDao;
import com.arno.domain.Objectively;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectivelyService {

    private final ObjectivelyDao objectivelyDao;

    public List<Objectively> getAll(){
        return objectivelyDao.findAll();
    }
}

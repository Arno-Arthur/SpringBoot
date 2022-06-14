package com.arno.service;

import com.arno.domain.Medications;
import com.arno.dao.MedicationsDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationsService {

    private final MedicationsDao medicationsDao;

    public List<Medications> getAll() {
        return medicationsDao.findAll();
    }

}

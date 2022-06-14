package com.arno.service;

import com.arno.domain.Call;
import com.arno.dao.CallDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CallService {

    private final CallDao callDao;

    public List<Call> getAll() {
        return callDao.findAll();
    }

    public Call getById(int id) {
        return callDao.findById(id).get();
    }

    public void deleteById(int id) {
        callDao.deleteById(id);
    }

    public List<Call> getForUser(int userId) {
        return callDao.getAllForUser(userId);
    }
}

package com.arno.service;

import com.arno.dao.TokenDao;
import com.arno.dao.UserDao;
import com.arno.domain.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenDao tokenDao;

    public Integer getUserIdByToken(String value) {
        return getTokenByValue(value).getUserId();
    }

    public Token getTokenByValue(String value) {
        return tokenDao.getTokenByValue(value);
    }

    public Token getTokenById(int id) {
        return  tokenDao.getTokenById(id);
    }

    public void updateToken(Token token) {
        tokenDao.save(token);
    }
}

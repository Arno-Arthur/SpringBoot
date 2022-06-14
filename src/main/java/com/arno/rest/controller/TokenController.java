package com.arno.rest.controller;

import com.arno.domain.User;
import com.arno.rest.dto.ResponseDto;
import com.arno.rest.dto.TokenDto;
import com.arno.service.TokenService;
import com.arno.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping("/token/expiration")
    public ResponseDto checkTokenExpiration(@RequestBody TokenDto token){
        ResponseDto response = new ResponseDto();

        Integer userId = tokenService.getUserIdByToken(token.getValue());
        User user;

        if (userId != null) {
            user = userService.getById(userId);
            response.setCode(100);
            response.setMessage("Токен активен");
        } else {
            response.setMessage("Пользователь не найден");
            response.setCode(99);
            return response;
        }

        long currentDate = Instant.now().getEpochSecond();
//        long tokenExpirationDate = user.getToken().getExpirationDate();
//
//        if (currentDate > tokenExpirationDate) {
//            response.setCode(98);
//            response.setMessage("Токен истек");
//            return response;
//        }
        return response;
    }
}

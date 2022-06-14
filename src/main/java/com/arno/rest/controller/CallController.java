package com.arno.rest.controller;

import com.arno.rest.dto.CallDto;
import com.arno.rest.dto.ResponseDto;
import com.arno.rest.dto.TokenDto;
import com.arno.service.CallService;
import com.arno.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class CallController {

    private final CallService callService;
    private final TokenService tokenService;

    @PostMapping("/calls")
    public ResponseDto getCallsForUser(@RequestBody TokenDto tokenDto){
        ResponseDto response = new ResponseDto();
        Integer userId = tokenService.getUserIdByToken(tokenDto.getValue());

        if (userId != null) {
            response.setCode(100);
        } else {
            response.setMessage("Пользователь не найден");
            response.setCode(0);
            return response;
        }

        long currentDate = Instant.now().getEpochSecond();
        long tokenExpirationDate = tokenService.getTokenByValue(tokenDto.getValue()).getExpirationDate().getTime();

        if (currentDate > tokenExpirationDate) {
            response.setCode(98);
            response.setMessage("Токен истек");
            return response;
        }

        List<CallDto> calls = callService.getForUser(userId).stream().map(CallDto::toDto).collect(Collectors.toList());
        response.setCalls(calls);
        if (calls.isEmpty()) {
            response.setCode(97);
            response.setMessage("Таблица звонков пуста");
            return response;
        }

        response.setMessage("Список получен");

        return response;
    }

    @GetMapping("/test")
    public String test() {
        return "Working";
    }
}

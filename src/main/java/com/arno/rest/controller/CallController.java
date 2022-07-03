package com.arno.rest.controller;

import com.arno.domain.Call;
import com.arno.domain.GeoPoint;
import com.arno.rest.dto.CallDto;
import com.arno.rest.dto.ResponseDto;
import com.arno.rest.dto.TokenDto;
import com.arno.service.CallService;
import com.arno.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
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

    @GetMapping("calls/delete")
    public ResponseDto deleteCall(@RequestParam("id") int id) {
        Call call = callService.getById(id);
        if (call == null) {
            return new ResponseDto("Пациента с таким идентификатором не существует", 97);
        } else {
            callService.deleteById(id);
            return new ResponseDto("Пациент удален", 100);
        }
    }

    @GetMapping("calls/add")
    public ResponseDto addCall(@RequestParam("name") String name, @RequestParam("userId") int userId) {
        Call call = new Call();
        call.setUserId(userId);
        call.setCallTime(new Date());
        call.setBornDate(new Date());
        call.setBcc("");
        call.setFirstName(name);
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitude(55.5815245);
        geoPoint.setLongitude(36.8251409);
        call.setGeoPoint(geoPoint);
        call.setSex((byte) 1);
        call.setLastName("Фамилия");
        call.setMiddleName("Отчество");
        call.setOrgName("ОРГАНИЗАЦИЯ");
        call.setEditCardDate(new Date());
        call.setResidence("Москва");
        call.setPassport("Паспорт 00000000");
        call.setSnils(12345678901L);
        call.setPolis(1234567812345678L);
        call.setReason("Причина\n Это тестовый пациент, данные подставлены по умолчанию");
        call.setPhoneNumber("89041449067");
        return new ResponseDto("Идентификатор пациента " + callService.addCall(call), 100);
    }
}

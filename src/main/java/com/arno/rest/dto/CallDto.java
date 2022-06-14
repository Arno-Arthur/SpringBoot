package com.arno.rest.dto;

import com.arno.domain.Call;
import com.arno.domain.GeoPoint;
import com.fasterxml.jackson.annotation.JsonFormat;
import liquibase.pro.packaged.S;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CallDto {

    private int id;
    private int userId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime callTime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate editCardDate;
    private String reason;
    private String bcc;
    private String firstName;
    private String middleName;
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate bornDate;
    private boolean sex;
    private String residence;
    private String phoneNumber;
    private String orgName;
    private String snils;
    private String polis;
    private String passport;
    private int age;
    private GeoPointDto geoPointDto;

    public static CallDto toDto (Call call){
        boolean sex = call.getSex() == 1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(call.getBornDate());
        int age = Year.now().getValue() - calendar.get(Calendar.YEAR);
        LocalDate editCardDate = new java.sql.Date(call.getCallTime().getTime()).toLocalDate();
        LocalDateTime callTime = new Timestamp(call.getCallTime().getTime()).toLocalDateTime();
        LocalDate bornDate = new java.sql.Date(call.getBornDate().getTime()).toLocalDate();
        return new CallDto(
                call.getId(),
                call.getUserId(),
                callTime,
                editCardDate,
                call.getReason(),
                call.getBcc(),
                call.getFirstName(),
                call.getMiddleName(),
                call.getLastName(),
                bornDate,
                sex,
                call.getResidence(),
                call.getPhoneNumber(),
                call.getOrgName(),
                call.getSnils() + "",
                call.getPolis() + "",
                call.getPassport(),
                age,
                GeoPointDto.toDto(call.getGeoPoint())
        );
    }
}

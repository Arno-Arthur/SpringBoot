package com.arno.rest.dto;

import com.arno.domain.Objectively;
import com.arno.domain.Registry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ObjectivelyDto {

    private int id;

    private RegistryDto registryDto;

    private String generalState;

    private String bodyBuild;

    private String skin;

    private String nodeAndGland;

    private String temperature;

    private String pharynx;

    private String respiratoryRate;

    private String breathing;

    private String arterialPressure;

    private String pulse;

    private String heartTones;

    private String abdomen;

    private String liver;

    private int registryId;

    private byte pensioner;

    private byte sick;

    public static ObjectivelyDto toDto(Objectively objectively){

        return new ObjectivelyDto(
                objectively.getId(),
                RegistryDto.toDto(objectively.getRegistry()),
                objectively.getGeneralState(),
                objectively.getBodyBuild(),
                objectively.getSkin(),
                objectively.getNodeAndGland(),
                objectively.getTemperature(),
                objectively.getPharynx(),
                objectively.getRespiratoryRate(),
                objectively.getBreathing(),
                objectively.getArterialPressure(),
                objectively.getPulse(),
                objectively.getHeartTones(),
                objectively.getAbdomen(),
                objectively.getLiver(),
                objectively.getRegistryId(),
                objectively.getPensioner(),
                objectively.getSick()
        );
    }

    public static Objectively toDomainObject(ObjectivelyDto objectivelyDto){

        return new Objectively(
                objectivelyDto.getId(),
                RegistryDto.toDomainObject(objectivelyDto.getRegistryDto()),
                objectivelyDto.getGeneralState(),
                objectivelyDto.getBodyBuild(),
                objectivelyDto.getSkin(),
                objectivelyDto.getNodeAndGland(),
                objectivelyDto.getTemperature(),
                objectivelyDto.getPharynx(),
                objectivelyDto.getRespiratoryRate(),
                objectivelyDto.getBreathing(),
                objectivelyDto.getArterialPressure(),
                objectivelyDto.getPulse(),
                objectivelyDto.getHeartTones(),
                objectivelyDto.getAbdomen(),
                objectivelyDto.getLiver(),
                objectivelyDto.getRegistryId(),
                objectivelyDto.getPensioner(),
                objectivelyDto.getSick()
        );
    }
}

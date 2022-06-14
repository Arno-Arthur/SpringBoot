package com.arno.rest.dto;

import com.arno.domain.Registry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistryDto {

    private int id;

    private int callId;

    private String complaints;

    private String anamnesis;

    private String recommendation;

    private String diagnosesId;

    private String createDate;

    private int objId;

    private String surveys;

    public static RegistryDto toDto(Registry registry){

        return new RegistryDto(
                registry.getId(),
                registry.getCallId(),
                registry.getComplaints(),
                registry.getAnamnesis(),
                registry.getRecommendation(),
                registry.getDiagnosesId(),
                registry.getCreateDate(),
                registry.getObjId(),
                registry.getSurveys()
        );
    }

    public static Registry toDomainObject(RegistryDto registryDto){

        return new Registry(
                registryDto.getId(),
                registryDto.getCallId(),
                registryDto.getComplaints(),
                registryDto.getAnamnesis(),
                registryDto.getRecommendation(),
                registryDto.getDiagnosesId(),
                registryDto.getCreateDate(),
                registryDto.getObjId(),
                registryDto.getSurveys()
        );
    }
}

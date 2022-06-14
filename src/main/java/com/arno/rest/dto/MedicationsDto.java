package com.arno.rest.dto;

import com.arno.domain.Medications;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MedicationsDto {

    private int id;

    private String category;

    private String name;

    private String receipt;

    public static MedicationsDto toDto(Medications medications){

        return new MedicationsDto(
                medications.getId(),
                medications.getCategory(),
                medications.getName(),
                medications.getReceipt()
        );
    }

    public static Medications toDomainObject(MedicationsDto medicationsDto){

        return new Medications(
                medicationsDto.getId(),
                medicationsDto.getCategory(),
                medicationsDto.getName(),
                medicationsDto.getReceipt()
        );
    }
}

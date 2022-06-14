package com.arno.rest.dto;

import com.arno.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrganizationDto {

    private int id;

    private String name;

    private String address;

    public static OrganizationDto toDto (Organization organization){

        return new OrganizationDto(
                organization.getId(),
                organization.getName(),
                organization.getAddress()
        );
    }

    public static Organization toDomainObject (OrganizationDto organizationDto){

        return new Organization(
                organizationDto.getId(),
                organizationDto.getName(),
                organizationDto.getAddress()
        );
    }

}

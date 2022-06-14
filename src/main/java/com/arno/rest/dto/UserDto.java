package com.arno.rest.dto;

import com.arno.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDto {

    private TokenDto tokenDto;
    private OrganizationDto organizationDto;

    private int id;

    @JsonProperty(value = "firstName")
    private String firstName;

    @JsonProperty(value = "middleName")
    private String middleName;

    @JsonProperty(value = "lastName")
    private String lastName;

    private String workingPosition;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String login;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String password;

    @JsonProperty("token")
    public TokenDto getTokenDto() {
        return tokenDto;
    }

    @JsonProperty("organization")
    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public static UserDto toDto(User user){
        return new UserDto(
                TokenDto.toDto(user.getToken()),
                OrganizationDto.toDto(user.getOrganization()),
                user.getId(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastname(),
                user.getWorkingPosition(),
                user.getLogin(),
                user.getPassword()
        );
    }

    public static User toDomainObject(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getMiddleName(),
                userDto.getLastName(),
                TokenDto.toDomainObject(userDto.getTokenDto()),
                userDto.getWorkingPosition(),
                userDto.getLogin(),
                userDto.getPassword(),
                OrganizationDto.toDomainObject(userDto.getOrganizationDto())
        );
    }
}

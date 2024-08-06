package com.teladoc.models;

import com.teladoc.constants.CustomerType;
import lombok.Builder;
import lombok.Getter;

/**
 * User details.
 *
 * @author navneet
 */
@Builder
@Getter
public class UserDetails {

    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String password;
    private final CustomerType customer;
    private final String role;
    private final String email;
    private final String cellPhone;
}

package com.firedance.gps.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author tangqi
 */
@Setter
@Getter
public class ClientAccount {
    private String id;
    private String account;
    private String password;
    private LocalDateTime serviceStartDateTime;
    private LocalDateTime serviceEndDateTime;
    private Boolean forbidden;
}

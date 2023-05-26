package com.firedance.gps.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author tangqi
 */
@Setter
@Getter
public class ServerAccount {
    private String id;
    private String ip;
    private String port;
    private String account;
    private String password;
    private LocalDateTime serviceStartDateTime;
    private LocalDateTime serviceEndDateTime;
    private Boolean inUse;
    private Boolean enable;
    private String disableReason;
}

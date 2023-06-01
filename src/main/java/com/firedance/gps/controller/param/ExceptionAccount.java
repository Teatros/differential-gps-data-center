package com.firedance.gps.controller.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionAccount {
    private String ip;
    private String port;
    private String account;
    private String exception;
}

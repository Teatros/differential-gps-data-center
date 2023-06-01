package com.firedance.gps.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author tangqi
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientLoginRecord {
    private Integer id;
    private String account;
    private String ip;
    private LocalDateTime loginDateTime;
}

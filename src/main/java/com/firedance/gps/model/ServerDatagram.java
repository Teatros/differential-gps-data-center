package com.firedance.gps.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServerDatagram {
    private String ip;
    private String port;
    private String account;
    private byte[] datagram;
}

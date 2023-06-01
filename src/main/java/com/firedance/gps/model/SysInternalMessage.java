package com.firedance.gps.model;

import com.firedance.gps.model.enums.AccountSpecificationEnum;
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
public class SysInternalMessage {
    private Integer id;
    private String message;
    private Boolean read;
    private LocalDateTime createDateTime;
}

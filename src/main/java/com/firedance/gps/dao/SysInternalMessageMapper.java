package com.firedance.gps.dao;

import com.firedance.gps.model.ClientAccount;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.SysInternalMessage;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * @author tangqi
 */
public interface SysInternalMessageMapper {
     void insert(SysInternalMessage sysInternalMessage);

    void updateRead(@Param("id")Integer id,@Param("read")Boolean read);
}

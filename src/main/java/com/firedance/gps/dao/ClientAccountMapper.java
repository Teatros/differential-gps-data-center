package com.firedance.gps.dao;

import com.firedance.gps.model.ClientAccount;
import com.firedance.gps.model.MessageDatagram;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * @author tangqi
 */
public interface ClientAccountMapper {
    /**
     * 获取客户端账户
     * @param account
     * @return
     */
    ClientAccount selectByAccount(@Param("account") String account);

    void insertLastDatagram(MessageDatagram datagram);

    void updateLoginDate(@Param("account")String account,@Param("time") LocalDateTime time);
}

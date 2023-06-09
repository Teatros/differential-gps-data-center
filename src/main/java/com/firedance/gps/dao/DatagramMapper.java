package com.firedance.gps.dao;

import com.firedance.gps.model.ClientAccount;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.ServerDatagram;
import org.apache.ibatis.annotations.Param;

/**
 * @author tangqi
 */
public interface DatagramMapper {

    /**
     * 插入报文信息
     * @param datagram
     */
    void insertGGA(MessageDatagram datagram);

    /**
     * 插入服务报文信息
     * @param datagram
     */
    void insertServerData(ServerDatagram datagram);


}

package com.firedance.gps.service;

import com.firedance.gps.model.MessageDatagram;

/**
 * @author tangqi
 */
public interface IClientAccountService {
    /**
     * 判断用户是否可用
     * @param account
     * @return
     */
    Boolean checkUserServiceEnable(String account);

    Boolean login(String account, String pw);

    /**
     * 上报gga
     * @param datagram
     * @return
     */
    void postGGA(MessageDatagram datagram);
}

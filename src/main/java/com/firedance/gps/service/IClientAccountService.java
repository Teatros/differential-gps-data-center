package com.firedance.gps.service;

import com.firedance.gps.model.ClientAccount;
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
    Boolean checkUserServiceEnable(String account) throws Exception;

    Boolean login(String account, String pw);

    /**
     * 上报gga
     * @param datagram
     * @return
     */
    void postGGA(MessageDatagram datagram);

    /**
     * 获取账户信息
     * @param account
     */
    ClientAccount getClientAccount(String account);
}

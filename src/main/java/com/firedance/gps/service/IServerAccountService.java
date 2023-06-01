package com.firedance.gps.service;

import com.firedance.gps.controller.param.ExceptionAccount;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.ServerAccount;
import com.firedance.gps.model.ServerDatagram;

/**
 * @author tangqi
 */
public interface IServerAccountService {

    /**
     * 提交异常账户
     * @param exceptionAccount
     */
    void postExceptionalAccount(ExceptionAccount exceptionAccount);

    /**
     * 获取可用服务器账号
     * @return
     */
    ServerAccount getEnabledAccount();

    void postBaseStationData(ServerDatagram messageDatagram);

    void giveBackAccount(ServerAccount account);
}

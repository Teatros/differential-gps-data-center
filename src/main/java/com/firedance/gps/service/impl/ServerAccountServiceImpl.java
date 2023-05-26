package com.firedance.gps.service.impl;

import com.firedance.gps.controller.param.ExceptionAccount;
import com.firedance.gps.dao.DatagramMapper;
import com.firedance.gps.dao.ServerAccountMapper;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.ServerAccount;
import com.firedance.gps.service.IServerAccountService;
import org.springframework.stereotype.Service;

/**
 * @author tangqi
 */
@Service
public class ServerAccountServiceImpl implements IServerAccountService {


    ServerAccountMapper serverAccountMapper;
    private DatagramMapper datagramMapper;

    public ServerAccountServiceImpl(ServerAccountMapper serverAccountMapper,
                                    DatagramMapper datagramMapper) {
        this.serverAccountMapper = serverAccountMapper;
        this.datagramMapper = datagramMapper;
    }

    @Override
    public void postExceptionalAccount(ExceptionAccount exceptionAccount) {
        serverAccountMapper.updateExceptionalAccount(exceptionAccount.getIp(),exceptionAccount.getPort(),exceptionAccount.getException());
    }

    @Override
    public ServerAccount getEnabledAccount() {
        return serverAccountMapper.selectEnableOne();
    }

    @Override
    public void postBaseStationData(MessageDatagram messageDatagram) {
        datagramMapper.insertServerData(messageDatagram);
    }

    @Override
    public void giveBackAccount(ServerAccount account) {
        account.setInUse(false);
        serverAccountMapper.updateOne(account);
    }
}

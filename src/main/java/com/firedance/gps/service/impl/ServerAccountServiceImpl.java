package com.firedance.gps.service.impl;

import com.firedance.gps.controller.param.ExceptionAccount;
import com.firedance.gps.dao.DatagramMapper;
import com.firedance.gps.dao.ServerAccountMapper;
import com.firedance.gps.dao.SysInternalMessageMapper;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.ServerAccount;
import com.firedance.gps.model.SysInternalMessage;
import com.firedance.gps.service.IServerAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author tangqi
 */
@Service
public class ServerAccountServiceImpl implements IServerAccountService {


    ServerAccountMapper serverAccountMapper;
    private DatagramMapper datagramMapper;
    private SysInternalMessageMapper sysInternalMessageMapper;

    public ServerAccountServiceImpl(ServerAccountMapper serverAccountMapper,
                                    DatagramMapper datagramMapper,
                                    SysInternalMessageMapper sysInternalMessageMapper) {
        this.serverAccountMapper = serverAccountMapper;
        this.datagramMapper = datagramMapper;
        this.sysInternalMessageMapper = sysInternalMessageMapper;
    }

    @Override
    public void postExceptionalAccount(ExceptionAccount exceptionAccount) {
        serverAccountMapper.updateExceptionalAccount(exceptionAccount.getIp(),exceptionAccount.getPort(),exceptionAccount.getAccount(),exceptionAccount.getException());
    }

    @Override
    public ServerAccount getEnabledAccount() {
        ServerAccount serverAccount = serverAccountMapper.selectEnableOne();
        Integer all = serverAccountMapper.countAll();
        Integer enableCount = serverAccountMapper.countEnable();
        String message = "";
        if(enableCount == 0){
            message = "登出用户资源可用账户为0，请及时补充";
        }else if(enableCount/all < 0.1){
            message = "登出用户资源可用账户低于10%，请及时补充";
        } else if(enableCount/all < 0.3){
            message = "登出用户资源可用账户低于30%，请及时补充";
        }
        SysInternalMessage build = SysInternalMessage.builder().read(false).createDateTime(LocalDateTime.now()).message(message).build();
        sysInternalMessageMapper.insert(build);
        return serverAccount;
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

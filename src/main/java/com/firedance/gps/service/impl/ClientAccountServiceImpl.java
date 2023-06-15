package com.firedance.gps.service.impl;

import com.firedance.gps.dao.ClientAccountMapper;
import com.firedance.gps.dao.ClientLoginRecordMapper;
import com.firedance.gps.dao.DatagramMapper;
import com.firedance.gps.model.ClientAccount;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.service.IClientAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author tangqi
 */
@Service
public class ClientAccountServiceImpl implements IClientAccountService {

    private ClientAccountMapper clientAccountMapper;
    private ClientLoginRecordMapper clientLoginRecordMapper;
    private DatagramMapper datagramMapper;

    public ClientAccountServiceImpl(ClientAccountMapper clientAccountMapper,
                                    ClientLoginRecordMapper clientLoginRecordMapper,
                                    DatagramMapper datagramMapper) {
        this.clientAccountMapper = clientAccountMapper;
        this.clientLoginRecordMapper = clientLoginRecordMapper;
        this.datagramMapper = datagramMapper;
    }

    @Override
    public Boolean checkUserServiceEnable(String account) throws Exception{
        ClientAccount clientAccount = clientAccountMapper.selectByAccount(account);
        if(clientAccount == null){
            return false;
        }
        if(clientAccount.getForbidden()){
            return false;
        }
        if(LocalDateTime.now().isAfter(clientAccount.getServiceEndDateTime())){
            return false;
        }
        return true;
    }

    @Override
    public Boolean login(String account, String pw) {
        ClientAccount clientAccount = clientAccountMapper.selectByAccount(account);
        if(null == clientAccount){
            return false;
        }
        if(!clientAccount.getPassword().equals(pw)){
            return false;
        }
        clientLoginRecordMapper.addLoginRecord(account,"");
        clientAccountMapper.updateLoginDate(account,LocalDateTime.now());
        return true;
    }

    @Override
    public void postGGA(MessageDatagram datagram) {
        datagramMapper.insertGGA(datagram);
        clientAccountMapper.insertLastDatagram(datagram);
    }

    @Override
    public ClientAccount getClientAccount(String account) {
        return clientAccountMapper.selectByAccount(account);
    }
}

package com.firedance.gps.controller;

import com.firedance.gps.handler.result.Result;
import com.firedance.gps.handler.result.ResultHelper;
import com.firedance.gps.model.ClientAccount;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.enums.AccountSpecificationEnum;
import com.firedance.gps.model.enums.ExceptionEnum;
import com.firedance.gps.model.enums.ServiceProviderEnum;
import com.firedance.gps.service.IClientAccountService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tangqi
 */
@RestController
public class ClientAccountController {

    IClientAccountService clientAccountService;

    public ClientAccountController(IClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @RequestMapping(value = "/client/login",method = RequestMethod.POST)
    public Result<Map<String,Object>> clientLogin(@RequestParam("account")String account, @RequestParam("pw")String pw){
        ClientAccount clientAccount = clientAccountService.getClientAccount(account);
        if(!clientAccount.getPassword().equals(pw)){
            ResultHelper.fail(ExceptionEnum.A000004.getCode(),ExceptionEnum.A000004.getMessage(),false );
        }
        Boolean login = clientAccountService.login(account, pw);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("result",login);
        if(login){
            result.put("serviceProvider",clientAccount.getServiceProvider());
        }
        return ResultHelper.success(result);
    }

    @RequestMapping(value = "/client/account/service_enable_status",method = RequestMethod.GET)
    public Result<Boolean> checkUserServiceEnable(@RequestParam("account")String account) throws Exception {
        return ResultHelper.success(clientAccountService.checkUserServiceEnable(account));
    }

    @RequestMapping(value = "/client/gga",method = RequestMethod.POST)
    public Result<Boolean> checkUserServiceEnable(@RequestBody MessageDatagram datagram){
        clientAccountService.postGGA(datagram);
        return ResultHelper.success(true);
    }

    @RequestMapping(value = "/client/account",method = RequestMethod.GET)
    public Result<ClientAccount> getClientAccount(@RequestParam("account") String account){
        ClientAccount clientAccount = clientAccountService.getClientAccount(account);
        return ResultHelper.success(clientAccount);
    }
}

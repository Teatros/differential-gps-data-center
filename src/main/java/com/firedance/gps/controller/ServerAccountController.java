package com.firedance.gps.controller;

import com.firedance.gps.controller.param.ExceptionAccount;
import com.firedance.gps.handler.result.Result;
import com.firedance.gps.handler.result.ResultHelper;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.ServerAccount;
import com.firedance.gps.service.IClientAccountService;
import com.firedance.gps.service.IServerAccountService;
import org.springframework.web.bind.annotation.*;

/**
 * @author tangqi
 */
@RestController
public class ServerAccountController {

    IServerAccountService serverAccountService;

    public ServerAccountController(IServerAccountService serverAccountService) {
        this.serverAccountService = serverAccountService;
    }

    @RequestMapping(value = "/server/exception_account",method = RequestMethod.POST)
    public Result<ServerAccount> postExceptionServerAccount(@RequestBody ExceptionAccount exceptionAccount){
        serverAccountService.postExceptionalAccount(exceptionAccount);
        ServerAccount serverAccount = serverAccountService.getEnabledAccount();
        return ResultHelper.success(serverAccount);
    }

    @RequestMapping(value = "/server/account",method = RequestMethod.GET)
    public Result<ServerAccount> getRandomEnabledServerAccount(){
        return ResultHelper.success(serverAccountService.getEnabledAccount());
    }

    @RequestMapping(value = "/server/base_station_data",method = RequestMethod.POST)
    public Result<Boolean> postBaseStationData(@RequestBody MessageDatagram messageDatagram){
        serverAccountService.postBaseStationData(messageDatagram);
        return ResultHelper.success(true);
    }

    @RequestMapping(value = "/server/account",method = RequestMethod.POST)
    public Result<Boolean> giveBackAccount(@RequestBody ServerAccount serverAccount){
        serverAccountService.giveBackAccount(serverAccount);
        return ResultHelper.success(true);
    }
}

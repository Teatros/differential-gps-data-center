package com.firedance.gps.controller;

import com.firedance.gps.handler.result.Result;
import com.firedance.gps.handler.result.ResultHelper;
import com.firedance.gps.model.ClientAccount;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.enums.AccountSpecificationEnum;
import com.firedance.gps.model.enums.ExceptionEnum;
import com.firedance.gps.service.IClientAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangqi
 */
@RestController
public class ClientAccountController {

    private static List<String> MOUNT_POINTS = new ArrayList<String>();
    static {
        MOUNT_POINTS.add("/RTCM33");
        MOUNT_POINTS.add("/RTCM33_GRCE");
        MOUNT_POINTS.add("/RTCM30_GR");
        MOUNT_POINTS.add("/RTCM33_GRC");
        MOUNT_POINTS.add("/RTCM33_GRCEpro");
        MOUNT_POINTS.add("/RTCM33_GRCEJ");
        MOUNT_POINTS.add("/RTCM411");
        MOUNT_POINTS.add("/RTCM33");
    }

    IClientAccountService clientAccountService;

    public ClientAccountController(IClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @RequestMapping(value = "/client/login",method = RequestMethod.POST)
    public Result<Boolean> clientLogin(@RequestParam("account")String account,@RequestParam("pw")String pw,@RequestParam("mountPoint")String mountPoint){
        if(!MOUNT_POINTS.contains(mountPoint)){
            return ResultHelper.fail(ExceptionEnum.A000001.getCode(),ExceptionEnum.A000001.getMessage(),false );
        }
        ClientAccount clientAccount = clientAccountService.getClientAccount(account);
        if(!clientAccount.getPassword().equals(pw)){
            ResultHelper.fail(ExceptionEnum.A000004.getCode(),ExceptionEnum.A000004.getMessage(),false );
        }
        return ResultHelper.success(clientAccountService.login(account,pw));
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

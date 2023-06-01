package com.firedance.gps.controller;

import com.firedance.gps.handler.result.Result;
import com.firedance.gps.handler.result.ResultHelper;
import com.firedance.gps.model.MessageDatagram;
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
        MOUNT_POINTS.add("");
    }

    IClientAccountService clientAccountService;

    public ClientAccountController(IClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @RequestMapping(value = "/client/login",method = RequestMethod.POST)
    public Result<Boolean> clientLogin(@RequestParam("account")String account,@RequestParam("pw")String pw){
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
}
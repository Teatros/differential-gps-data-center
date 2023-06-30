package com.firedance.gps.controller;

import com.firedance.gps.controller.param.ExceptionAccount;
import com.firedance.gps.handler.result.Result;
import com.firedance.gps.handler.result.ResultHelper;
import com.firedance.gps.model.MessageDatagram;
import com.firedance.gps.model.ServerAccount;
import com.firedance.gps.model.ServerDatagram;
import com.firedance.gps.model.enums.ServiceProviderEnum;
import com.firedance.gps.service.IClientAccountService;
import com.firedance.gps.service.IServerAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result<Boolean> postExceptionServerAccount(@RequestBody ExceptionAccount exceptionAccount){
        serverAccountService.postExceptionalAccount(exceptionAccount);
        return ResultHelper.success(true);
    }

    @RequestMapping(value = "/server/account",method = RequestMethod.GET)
    public Result<ServerAccount> getRandomEnabledServerAccount(@RequestParam("clientAccountServiceProvider")String serviceProvider,@RequestParam("mountPoint")String mountPoint){
        ServiceProviderEnum serviceProviderEnum = ServiceProviderEnum.valueOf(serviceProvider);
        List<String> mountPoints = serviceProviderEnum.getMountPoints();
        if(!mountPoints.contains(mountPoint)){
            mountPoint = serviceProviderEnum.getDefaultMountPoint();
        }
        ServerAccount enabledAccount = serverAccountService.getEnabledAccount(serviceProvider, mountPoint);
        if(enabledAccount == null){
            enabledAccount = serverAccountService.getEnabledAccount(serviceProvider, null);
        }
        return ResultHelper.success(enabledAccount);
    }

    @RequestMapping(value = "/server/base_station_data",method = RequestMethod.POST,consumes = "application/octet-stream")
    public Result<Boolean> postBaseStationData(@RequestParam("ip")String ip,
                                               @RequestParam("port")String port,
                                               @RequestParam("account")String account,
                                               @RequestBody byte[] binaryData){
        ServerDatagram datagram =
            ServerDatagram.builder().ip(ip).port(port).account(account).datagram(binaryData).build();
        serverAccountService.postBaseStationData(datagram);
        return ResultHelper.success(true);
    }

    @RequestMapping(value = "/server/account",method = RequestMethod.POST)
    public Result<Boolean> giveBackAccount(@RequestBody ServerAccount serverAccount){
        serverAccountService.giveBackAccount(serverAccount);
        return ResultHelper.success(true);
    }
}

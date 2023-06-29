package com.firedance.gps.dao;

import com.firedance.gps.model.ClientAccount;
import com.firedance.gps.model.ServerAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tangqi
 */
public interface ServerAccountMapper {
    /**
     * 更新异常账户
     * @param account
     * @param reason
     * @param exception
     */
    void updateExceptionalAccount(@Param("ip") String ip, @Param("port") String port,
                                  @Param("account") String account, @Param("exception")String exception);

    /**
     * 获取可用账户
     * @param serviceProvider
     * @param mountPoint
     */
    ServerAccount selectEnableOne(@Param("serviceProvider")String serviceProvider,@Param("mountPoint") String mountPoint);

    /**
     * 根据ip+port更新
     * @param serverAccount
     */
    void updateOne(ServerAccount serverAccount);

    Integer countEnable();

    Integer countAll();
}

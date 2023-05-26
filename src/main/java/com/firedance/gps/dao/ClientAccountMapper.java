package com.firedance.gps.dao;

import com.firedance.gps.model.ClientAccount;
import org.apache.ibatis.annotations.Param;

/**
 * @author tangqi
 */
public interface ClientAccountMapper {
    /**
     * 获取客户端账户
     * @param account
     * @return
     */
    ClientAccount selectByAccount(@Param("account") String account);
}

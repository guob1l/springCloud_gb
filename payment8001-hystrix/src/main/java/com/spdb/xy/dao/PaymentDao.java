package com.spdb.xy.dao;

import com.spdb.xy.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: dao
 * @Param:
 * @return:
 * @Author: gb
 * @Date: 2021/3/28
 */
@Mapper
@Repository
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}

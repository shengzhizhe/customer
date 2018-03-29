package org.customer.com.coupon.service.serviceImpl;

import com.github.pagehelper.Page;
import org.customer.com.coupon.mapper.CouponMapper;
import org.customer.com.coupon.model.Coupon;
import org.customer.com.coupon.service.CouponService;
import org.customer.com.util.resultJson.ResponseResult;
import org.customer.com.util.sl4j.Sl4jToString;
import org.customer.com.volume.service.impl.VolumeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService{

    private static Logger logger = LoggerFactory.getLogger(VolumeServiceImpl.class);

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private CouponMapper mapper;
    @Autowired
    private ResponseResult<Coupon> result;


    @Override
    public ResponseResult findByActivity(String activity) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                activity+"",
                result.getCode(),
                null));
        List<Coupon> byActivity = mapper.findByActivity(activity);
        ResponseResult<List<Coupon>> result = new ResponseResult<>();
        result.setSuccess(true);
        result.setData(byActivity);
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                activity+"",
                result.getCode(),
                null));
        return result;
    }
}

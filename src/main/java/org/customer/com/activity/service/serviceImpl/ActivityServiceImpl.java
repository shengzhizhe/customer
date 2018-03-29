package org.customer.com.activity.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.customer.com.activity.mapper.ActivityMapper;
import org.customer.com.activity.model.Activity;
import org.customer.com.activity.service.ActivityService;
import org.customer.com.commodity.mapper.CommodityMapper;
import org.customer.com.commodity.model.CommodityModel;
import org.customer.com.commodity.service.serviceImpl.CommodityServiceImpl;
import org.customer.com.util.resultJson.ResponseResult;
import org.customer.com.util.sl4j.Sl4jToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private ActivityMapper mapper;
    @Autowired
    private ResponseResult<Activity> result;

    @Override
    public ResponseResult page(int pageNow, int pageSize, String classification) {
        logger.info(Sl4jToString.info(
                1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow+":"+pageSize+":"+classification,
                result.getCode(),
                null));
        ResponseResult<Page<Activity>> result = new ResponseResult();
        PageHelper.startPage(pageNow,pageSize);
        Page<Activity> page = mapper.page(classification);
        result.setSuccess(true);
        result.setData(page);
        logger.info(Sl4jToString.info(
                2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow+":"+pageSize+":"+classification,
                this.result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult getByUuid(String uuid) {
        logger.info(Sl4jToString.info(
                1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid+"",
                result.getCode(),
                null));
        Activity byName = mapper.getByUuid(uuid);
        if(byName==null||"".equals(byName)){
            result.setSuccess(false);
            result.setMessage("抱歉，该活动结束");
        }else {
            result.setSuccess(true);
            result.setData(byName);
            if(byName.getType()==0){
                result.setMessage("活动尚未开启");
                result.setCode(201);
            }else if(byName.getType()==2){
                result.setMessage("抱歉，活动已结束");
                result.setCode(202);
            }else {
            result.setMessage("成功");
            }
        }
        logger.info(Sl4jToString.info(
                2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid+"",
                result.getCode(),
                null));
        return result;
    }
}

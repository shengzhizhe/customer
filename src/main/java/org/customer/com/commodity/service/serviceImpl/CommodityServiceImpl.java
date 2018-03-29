package org.customer.com.commodity.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.customer.com.commodity.mapper.CommodityMapper;
import org.customer.com.commodity.model.CommodityModel;
import org.customer.com.commodity.service.CommodityService;
import org.customer.com.personal.model.PersonalModel;
import org.customer.com.personal.service.serviceImpl.PersonalServiceImpl;
import org.customer.com.util.resultJson.ResponseResult;
import org.customer.com.util.sl4j.Sl4jToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * logger.info(Sl4jToString.info(1,
 * serviceName,
 * Thread.currentThread().getStackTrace()[1].getMethodName(),
 * model.toString(),
 * 200,
 * null));
 */
@Service
public class CommodityServiceImpl implements CommodityService{

    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private CommodityMapper mapper;
    @Autowired
    private ResponseResult<CommodityModel> result;

    @Override
    public ResponseResult findAllByPage(int pageNow, int pageSize,String lm) {
        logger.info(Sl4jToString.info(
                1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow+":"+pageSize+":"+lm,
                result.getCode(),
                null));
        ResponseResult<Page<CommodityModel>> result = new ResponseResult<>();
        PageHelper.startPage(pageNow,pageSize);
        Page<CommodityModel> allByPage = mapper.findAllByPage(lm);
        result.setSuccess(true);
        result.setData(allByPage);
        result.setMessage("成功");
        logger.info(Sl4jToString.info(
                2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                pageNow+":"+pageSize+":"+lm,
                result.getCode(),
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
        CommodityModel byName = mapper.getByUuid(uuid);
        if(byName==null||"".equals(byName)){
            result.setSuccess(false);
            result.setMessage("抱歉，该商品已下架");
        }else {
            result.setSuccess(true);
            result.setMessage("成功");
            result.setData(byName);
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

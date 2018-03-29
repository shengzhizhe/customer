package org.customer.com.order.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.customer.com.commodity.model.CommodityModel;
import org.customer.com.commodity.service.serviceImpl.CommodityServiceImpl;
import org.customer.com.order.mapper.OrderMapper;
import org.customer.com.order.model.OrderModel;
import org.customer.com.order.service.OrderService;
import org.customer.com.util.resultJson.ResponseResult;
import org.customer.com.util.sl4j.Sl4jToString;
import org.customer.com.util.uuidUtil.GetUuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Value("${spring.application.name}")
    private String serviceName;
    @Autowired
    private ResponseResult<OrderModel> result;
    @Autowired
    private OrderMapper mapper;

    @Override
    public ResponseResult add(OrderModel model) {
        logger.info(Sl4jToString.info(
                1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.getDdbh()+"",
                result.getCode(),
                null));
        model.setUuid(GetUuid.getUUID());
        int add = mapper.add(model);
        if(add==1){
            result.setSuccess(true);
            result.setMessage("成功");
        }else{
            result.setSuccess(false);
            result.setMessage("失败");
        }
        logger.info(Sl4jToString.info(
                2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.getDdbh()+"",
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult findByCjr(int pageNow,int pageSize,String account) {
        logger.info(Sl4jToString.info(
                1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                account+"",
                result.getCode(),
                null));
        ResponseResult<Page<OrderModel>> result = new ResponseResult<>();
        PageHelper.startPage(pageNow,pageSize);
        Page<OrderModel> byCjr = mapper.findByCjr(account);
        result.setSuccess(true);
        result.setData(byCjr);
        logger.info(Sl4jToString.info(
                2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                account+"",
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult findById(String uuid) {
        logger.info(Sl4jToString.info(
                1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid+"",
                result.getCode(),
                null));
        OrderModel byId = mapper.findById(uuid);
        result.setSuccess(true);
        result.setData(byId);
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

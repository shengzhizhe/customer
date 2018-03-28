package org.customer.com.volume.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.customer.com.volume.mapper.VolumeMapper;
import org.customer.com.volume.model.VolumeModel;
import org.customer.com.volume.service.VolumeService;
import org.customer.com.util.resultJson.ResponseResult;
import org.customer.com.util.sl4j.Sl4jToString;
import org.customer.com.util.uuidUtil.GetUuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class VolumeServiceImpl implements VolumeService {

    private static Logger logger = LoggerFactory.getLogger(VolumeServiceImpl.class);

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private VolumeMapper mapper;
    @Autowired
    private ResponseResult<VolumeModel> result;

    @Override
    public ResponseResult<VolumeModel> save(VolumeModel model) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString(),
                result.getCode(),
                null));
//          判断活动是否到期(放入client做判断)
//          判断是否有未使用的
        List<VolumeModel> list = mapper.findByActivity(model.getActivity(), model.getAccountId(), "N");
        if (list != null && list.size() > 0) {
            result.setSuccess(false);
            result.setCode(501);
            return result;
        }

        model.setUuid(GetUuid.getUUID());
        model.setReceiveTimes(new Timestamp(System.currentTimeMillis()));
        model.setUse("N");
        int i = mapper.save(model);
        switch (i) {
            case 0:
                result.setSuccess(true);
                result.setCode(201);
                break;
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                break;
            default:
                result.setSuccess(false);
                result.setCode(500);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString(),
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult<Page<VolumeModel>> findAll(int now, int size, String use) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                now + "," + size,
                result.getCode(),
                null));
        ResponseResult<Page<VolumeModel>> result = new ResponseResult<>();
        PageHelper.startPage(now, size);
        Page<VolumeModel> page = mapper.findAll(use);
        result.setSuccess(true);
        result.setCode(200);
        result.setData(page);
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                now + "," + size,
                result.getCode(),
                null));
        return result;
    }
}

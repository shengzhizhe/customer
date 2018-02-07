package org.customer.com.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.customer.com.mapper.PersonalMapper;
import org.customer.com.model.PersonalModel;
import org.customer.com.service.PersonalService;
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

/**
 * logger.info(Sl4jToString.info(1,
 * serviceName,
 * Thread.currentThread().getStackTrace()[1].getMethodName(),
 * model.toString(),
 * 200,
 * null));
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PersonalServiceImpl implements PersonalService {

    private static Logger logger = LoggerFactory.getLogger(PersonalServiceImpl.class);

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private PersonalMapper mapper;
    @Autowired
    private ResponseResult<PersonalModel> result;

    @Override
    public ResponseResult<PersonalModel> save(PersonalModel model) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString(),
                result.getCode(),
                null));
        if (model.getNickname() != null && !model.getNickname().isEmpty()) {
            PersonalModel model1 = mapper.getByNickname(model.getNickname());
            if (model1 != null) {
                result.setSuccess(false);
                result.setCode(501);
                logger.info(Sl4jToString.info(2,
                        serviceName,
                        Thread.currentThread().getStackTrace()[1].getMethodName(),
                        model.toString(),
                        result.getCode(),
                        null));
                return result;
            }
        }
        model.setUuid(GetUuid.getUUID());
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
                default:result.setSuccess(false);
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
    public ResponseResult<PersonalModel> delete(String id) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id,
                result.getCode(),
                null));
        int i = mapper.delete(id);
        switch (i) {
            case 0:
                result.setSuccess(true);
                result.setCode(201);
                break;
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                break;
            default:result.setSuccess(false);
                result.setCode(500);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult<PersonalModel> update(PersonalModel model) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                model.toString(),
                result.getCode(),
                null));
        int i = mapper.update(model);
        switch (i) {
            case 0:
                result.setSuccess(true);
                result.setCode(201);
                break;
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                break;
            default:result.setSuccess(false);
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
    public ResponseResult<Page<PersonalModel>> findAll(int now, int size) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                null,
                result.getCode(),
                null));
        ResponseResult<Page<PersonalModel>> result = new ResponseResult<>();
        PageHelper.startPage(now, size);
        Page<PersonalModel> page = mapper.findAll();
        result.setSuccess(true);
        result.setCode(200);
        result.setData(page);
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                null,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult<PersonalModel> getById(String id) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id,
                result.getCode(),
                null));
        PersonalModel model = mapper.getById(id);
        if (model != null) {
            result.setSuccess(true);
            result.setCode(200);
            result.setData(model);
        } else {
            result.setSuccess(false);
            result.setCode(404);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                id,
                result.getCode(),
                null));
        return result;
    }

    @Override
    public ResponseResult<PersonalModel> getByAccount(String account) {
        logger.info(Sl4jToString.info(1,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                account,
                result.getCode(),
                null));
        PersonalModel model = mapper.getByAccount(account);
        if (model != null) {
            result.setSuccess(true);
            result.setCode(200);
            result.setData(model);
        } else {
            result.setSuccess(false);
            result.setCode(404);
        }
        logger.info(Sl4jToString.info(2,
                serviceName,
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                account,
                result.getCode(),
                null));
        return result;
    }
}

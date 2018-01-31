package org.customer.com.service.impl;

import com.github.pagehelper.Page;
import org.customer.com.mapper.PersonalMapper;
import org.customer.com.model.PersonalModel;
import org.customer.com.service.PersonalService;
import org.customer.com.util.resultJson.ResponseResult;
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
    private ResponseResult result;

    @Override
    public ResponseResult<PersonalModel> saven(PersonalModel model) {
        model.setUuid(GetUuid.getUUID());
        int i = mapper.saven(model);
        switch (i) {
            case 0:
                result.setSuccess(true);
                result.setCode(201);
                break;
            case 1:
                result.setSuccess(true);
                result.setCode(200);
                break;
        }
        return null;
    }

    @Override
    public ResponseResult<PersonalModel> delete(String id) {
        return null;
    }

    @Override
    public ResponseResult<PersonalModel> update(PersonalModel model) {
        return null;
    }

    @Override
    public ResponseResult<Page<PersonalModel>> findAll() {
        return null;
    }

    @Override
    public ResponseResult<PersonalModel> getById(String id) {
        return null;
    }

    @Override
    public ResponseResult<PersonalModel> getByAccount(String account) {
        return null;
    }
}

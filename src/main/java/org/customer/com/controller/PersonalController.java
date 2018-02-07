package org.customer.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.customer.com.model.PersonalModel;
import org.customer.com.service.PersonalService;
import org.customer.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * '@name' 用户管理
 * <p>
 * '@Api' 用在类上，说明该类的作用
 * '@ApiOperation' 用在方法上，说明方法的作用
 * '@ApiImplicitParams' 用在方法上包含一组参数说明
 * '@ApiImplicitParam' 用在@ApiImplicitParams注解中，指定一个请求参数的各个方面 paramType：参数放在哪个地方
 * header-->请求参数的获取：@RequestHeader
 * query-->请求参数的获取：@RequestParam
 * path（用于restful接口）-->请求参数的获取：@PathVariable
 * body（不常用）
 * form（不常用）
 * name：参数名
 * dataType：参数类型
 * required：参数是否必须传
 * value：参数的意思
 * defaultValue：参数的默认值
 * '@ApiResponses'：用于表示一组响应
 * '@ApiResponse'：用在@ApiResponses中，一般用于表达一个错误的响应信息 code：数字，例如400
 * message：信息，例如"请求参数没填好"
 * response：抛出异常的类
 * '@ApiModel'：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，
 * 请求参数无法使用@ApiImplicitParam注解进行描述的时候）
 * '@ApiModelProperty'：描述一个model的属性
 */
@Api(value = "personal", description = "个人资料")
@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalService service;

    @ApiOperation(value = "个人资料分页",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET)
    public ResponseResult init(@RequestParam(value = "pageNow") int pageNow,
                               @RequestParam(value = "pageSize") int pageSize) {
        return service.findAll(pageNow, pageSize);
    }

    @ApiOperation(value = "根据账户查找",
            notes = "根据账户获取个人资料",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/account",
            method = RequestMethod.GET)
    public ResponseResult get(@RequestParam("account") String account) {
        return service.getByAccount(account);
    }

    @ApiOperation(value = "更新个人资料",
            notes = "更新个人资料",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult update(@Valid @RequestBody PersonalModel model, BindingResult bindingResult) {
        //数据验证
        if (bindingResult.hasErrors()) {
            ResponseResult<PersonalModel> result = new ResponseResult<>();
            result.setSuccess(false);
            result.setCode(400);
            result.setData(model);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        if (model.getUuid() == null || model.getUuid().isEmpty())
            return service.save(model);
        else
            return service.update(model);
    }
}

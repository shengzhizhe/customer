package org.customer.com.volume.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.customer.com.volume.model.VolumeModel;
import org.customer.com.volume.service.VolumeService;
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
@Api(value = "volume", description = "领卷记录")
@RestController
@RequestMapping("/volume")
public class VolumeController {

    @Autowired
    private VolumeService service;

    @ApiOperation(value = "领卷记录分页",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(value = "/volume/page/{pageNow}/{pageSize}/{use}",
            method = RequestMethod.GET)
    public ResponseResult findAll(@PathVariable(value = "pageNow") int pageNow,
                                  @PathVariable(value = "pageSize") int pageSize,
                                  @PathVariable(value = "use") String use) {
        return service.findAll(pageNow, pageSize,use);
    }

    @ApiOperation(value = "新增领卷记录",
            notes = "新增领卷记录",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/volume",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult save(@Valid @RequestBody VolumeModel model, BindingResult bindingResult) {
        //数据验证
        if (bindingResult.hasErrors()) {
            ResponseResult<VolumeModel> result = new ResponseResult<>();
            result.setSuccess(false);
            result.setCode(400);
            result.setData(model);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        return service.save(model);
    }
}

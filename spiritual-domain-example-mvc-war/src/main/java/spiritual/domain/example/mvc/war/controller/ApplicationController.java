/*
 *
 */
package spiritual.domain.example.mvc.war.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiritual.domain.example.mvc.war.ApplicationProperties;

import java.util.Date;

/**
 *
 */
@Api(tags = "测试模块", description = "测试模块接口文档")
@Controller
public class ApplicationController {

    /**
     *
     */
    private final ApplicationProperties applicationProperties;

    /**
     *
     */
    @Autowired
    public ApplicationController(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    /**
     *
     */
    @ApiOperation(value = "起始路径", notes = "起始路径。")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:index";
    }

    /**
     *
     */
    @ApiOperation(value = "首页路径", notes = "首页路径。")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     *
     */
    @ApiOperation(value = "欢迎路径", notes = "欢迎路径。")
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public Date welcome() {
        return new Date();
    }

    /**
     *
     */
    @ApiOperation(value = "欢迎信息", notes = "欢迎信息。")
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public String message() {
        return applicationProperties.getMessage();
    }

}

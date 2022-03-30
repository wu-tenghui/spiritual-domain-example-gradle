/*
 *
 */
package spiritual.domain.example.webflux.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spiritual.domain.example.webflux.ApplicationProperties;

import java.util.Date;

/**
 *
 */
@Tag(name = "测试模块", description = "测试模块接口文档")
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
    @Operation(summary = "起始路径", description = "起始路径。")
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String root() {
        return "redirect:/index";
    }

    /**
     *
     */
    @Operation(summary = "首页路径", description = "首页路径。")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     *
     */
    @Operation(summary = "欢迎路径", description = "欢迎路径。")
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public Date welcome() {
        return new Date();
    }

    /**
     *
     */
    @Operation(summary = "欢迎信息", description = "欢迎信息。")
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public String message() {
        return applicationProperties.getMessage();
    }

    /**
     *
     */
    @Operation(summary = "欢迎路径(webflux)", description = "欢迎路径(webflux)。")
    @RequestMapping(value = "/welcome/webflux", method = RequestMethod.GET)
    @ResponseBody
    public Mono<Date> welcomeWebflux() {
        return Mono.just(new Date());
    }

    /**
     *
     */
    @Operation(summary = "欢迎信息(webflux)", description = "欢迎信息(webflux)。")
    @RequestMapping(value = "/message/webflux", method = RequestMethod.GET)
    @ResponseBody
    public Flux<String> messageWebflux() {
        return Flux.just(applicationProperties.getMessage());
    }

}

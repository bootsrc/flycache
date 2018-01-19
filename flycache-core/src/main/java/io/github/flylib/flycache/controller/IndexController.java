package io.github.flylib.flycache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.controller
 * @Description:
 * @date 2018-1-19 9:55
 */
@Controller
public class IndexController {
    @ResponseBody
    @RequestMapping("")
    public String demo() {
        return "demo response from flycache-core.-------";
    }
}

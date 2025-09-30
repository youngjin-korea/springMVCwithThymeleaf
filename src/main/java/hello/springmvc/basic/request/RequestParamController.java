package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response, @CookieValue(value = "savedId", required = false) String savedId) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={} cookie = {}", username, age, savedId);

        response.getWriter().write("ok");
    }

    @ResponseBody // 뷰리졸버 호출 없이 messagebody에 넣음
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam(value = "username", required = false) String memberName, @RequestParam(value = "age", required = true, defaultValue = "12") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);
        return "OK";
    }

    @ResponseBody // 뷰리졸버 호출 없이 messagebody에 넣음
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody // 뷰리졸버 호출 없이 messagebody에 넣음
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);
        return "OK";
    }
}

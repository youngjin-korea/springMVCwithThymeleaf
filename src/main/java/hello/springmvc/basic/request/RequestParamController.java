package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {

//    @RequestMapping("/request-param-v1")
//    public void requestParamV1(HttpServletRequest request, HttpServletResponse response, @CookieValue(value = "savedId", required = false) String savedId) throws IOException {
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
//        log.info("username={}, age={} cookie = {}", username, age, savedId);
//
//        response.getWriter().write("ok");
//    }
//
//    @ResponseBody // 뷰리졸버 호출 없이 messagebody에 넣음
//    @RequestMapping("/request-param-v2")
//    public String requestParamV2(@RequestParam(value = "username", required = false) String memberName, @RequestParam(value = "age", required = true, defaultValue = "12") int memberAge) {
//        log.info("username={}, age={}", memberName, memberAge);
//        return "OK";
//    }
//
//    @ResponseBody // 뷰리졸버 호출 없이 messagebody에 넣음
//    @RequestMapping("/request-param-v3")
//    public String requestParamV3(@RequestParam String username, @RequestParam int age) {
//        log.info("username={}, age={}", username, age);
//        return "OK";
//    }
//
//    @ResponseBody // 뷰리졸버 호출 없이 messagebody에 넣음
//    @RequestMapping("/request-param-v4")
//    public String requestParamV4(String username, int age) {
//        log.info("username={}, age={}", username, age);
//        return "OK";
//    }
//
//    /**
//     *
//     * @param username
//     * @param age
//     * @return
//     *RequestParam -> ModelAttribute
//     */
//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public HelloData modelAttributeV1 (@RequestParam String username, @RequestParam("age") int age) {
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//
//        return helloData;
//    }
//    /*
//    * HelloData 생성 -> 요청 파라미터에 해당하는 setter를 호출해서 바인딩 (필수적으로 getter, setter가 필요함)
//    * */
//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public HelloData modelAttributeV1 (@ModelAttribute HelloData helloData) {
//        return helloData;
//    }
//    /*
//    * String, int, Integer 등의 단순 타입은 @RequestParam을 사용하지만 HelloData같은 객체를 인자로 받을때는 @ModelAttribute를 사용해서
//    * 객체를 생성함과 동시에 바인딩이 가능하다.(단 Argument Resolver로 지정해둔 아규먼트는 예외- HttpServletRequest 같은게 해당됨)
//    * */

}

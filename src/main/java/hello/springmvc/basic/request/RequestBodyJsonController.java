package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream messageBodyByteCode = request.getInputStream();
        String messageBodyString = StreamUtils.copyToString(messageBodyByteCode, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBodyString);

        HelloData helloData = objectMapper.readValue(messageBodyString, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write(messageBodyString);
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {

        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        return helloData.toString();
    }

    /**
     * @RequestBody 사용시에 header에 content-type: application/json 타입으로 넣어주어야 messageBody의 메세지를 읽어서 컨버팅 해줌
     *
     * @param helloData
     * @return
     */
    @ResponseBody // 응답 시에도 json으로 변형해서 messageBody에 넣어줌 -> Accept: application/json
    @PostMapping("/request-body-json-v3")
    public HelloData requestBodyJsonV3(@RequestBody HelloData helloData) {

        log.info("messageBody={}", helloData.toString());

        return helloData;
    }
}

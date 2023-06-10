package com.cudo.pixelviewer.setting.controller;

import com.cudo.pixelviewer.component.TcpSender;
import com.cudo.pixelviewer.setting.service.SettingService;
import com.cudo.pixelviewer.util.ParameterUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SettingController {

    final SettingService settingService;

    final TcpSender tcpSender;

    /**
     * setting >> service Key-Value
     *
     * @return responseMap
     */
    @GetMapping("/api/setting/getValue")
    public Map<String, Object> settingGetValue(HttpServletRequest request) {
        long startTime = System.currentTimeMillis();
        String apiInfo = "["+ request.getRequestURI() + "] [" + request.getMethod() + "]";
        log.info("{} [START] [{}]", apiInfo, startTime);

        Map<String, Object> responseMap = new HashMap<>();


        byte[] payload = {01, 02, 03};
        tcpSender.sendMessage(payload);


        try {
            responseMap = settingService.serviceGetValue();
        }
        catch (Exception exception) {
            log.error(exception.getMessage());
            responseMap.putAll(ParameterUtils.responseOption("FAIL"));
            responseMap.put("exceptionMessage", exception.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long procTime = endTime-startTime;
        log.info("{} [END] [{}] - {}", apiInfo, procTime, responseMap.get("code"));

        return responseMap;
    }
}

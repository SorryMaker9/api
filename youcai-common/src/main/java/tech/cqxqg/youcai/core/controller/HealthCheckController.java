package tech.cqxqg.youcai.core.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HealthCheckController {

	@GetMapping("ping")
	public String ping(@RequestParam(defaultValue = "false") Boolean debug, HttpServletRequest request) {
		if (debug) {
			Enumeration<String> e = request.getHeaderNames();
			while (e.hasMoreElements()) {
				String name = e.nextElement();
				log.info("{} = {}", name, request.getHeader(name));
			}
		}
		return "pong";
	}
}

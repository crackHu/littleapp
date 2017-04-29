/**
 * @Company Copyright © 2017 油兔不二. All rights reserved.
 *
 * @Title: LoggingTest.java
 * @Prject: wechat-littleapp-server
 * @Package: ml.littleapp.web.rest.util
 * @Description: TODO
 * @author: crack
 * @date: 2017年4月25日 上午1:21:19
 * @version: V1.0
 */
package ml.littleapp.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingTest {

	@GetMapping("/auth/logging/{name}")
	public String test(@PathVariable("name") String hehe) {
		return String.format("Hello, %s", hehe);
	}
}

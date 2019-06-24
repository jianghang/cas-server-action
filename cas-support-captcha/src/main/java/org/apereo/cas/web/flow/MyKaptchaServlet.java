package org.apereo.cas.web.flow;

import com.google.code.kaptcha.servlet.KaptchaServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by Administrator on 2019/6/19.
 */
@WebServlet(urlPatterns = "/kaptcha.jpg", initParams = {
        @WebInitParam(name = "kaptcha.image.width", value = "200"),
        @WebInitParam(name = "kaptcha.image.height", value = "50"),
        @WebInitParam(name = "kaptcha.textproducer.char.length", value = "4"),
        @WebInitParam(name = "kaptcha.noise.impl", value = "com.google.code.kaptcha.impl.NoNoise"),
        @WebInitParam(name = "kaptcha.session.key", value = "captcha_code")
})
public class MyKaptchaServlet extends KaptchaServlet {
}

package com.zyl.cases.Jetty.controller;

import ch.qos.logback.classic.Logger;
import com.zyl.cases.Jetty.repository.entity.User;
import com.zyl.cases.Jetty.service.UserService;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class JettyController {

  private static final Logger logger =
      (Logger) LoggerFactory.getLogger(JettyController.class);

  @Resource
  private UserService userService;

  @RequestMapping(value = "/hello/{userId}", method = RequestMethod.GET)
  public void hello(@PathVariable String userId, HttpServletRequest request, HttpServletResponse response) throws Exception {
    logger.info("===============================");
    response.setContentType("text/html;charset=utf-8");
    response.setCharacterEncoding("utf-8");
    response.setStatus(HttpServletResponse.SC_OK);
    User user = userService.getUserById(userId);
    PrintWriter out = response.getWriter();
    System.out.println(2);
    out.println("hello " + user.getName());
  }


  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  public void helloPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    InputStream is = request.getInputStream();
    is.read();

  }


}

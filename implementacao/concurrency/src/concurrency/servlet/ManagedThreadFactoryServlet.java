package concurrency.servlet;


import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concurrency.task.RunnableTask;

//http://localhost:8080/concurrency/MTFServlet
//@WebServlet("/MTFServlet")
public class ManagedThreadFactoryServlet extends HttpServlet {
	private static final long serialVersionUID = -7366024900440622521L;

	// @Resource(name = "java:jboss/ee/concurrency/factory/Aula_MTF")
	 private ManagedThreadFactory managedThreadFactory;

	 private static final Logger LOG =
	  Logger.getLogger(ManagedThreadFactoryServlet.class.getSimpleName());

	 protected void doGet(HttpServletRequest request,
	  HttpServletResponse response) throws ServletException, IOException {
	  LOG.info("Executando task..");
	  managedThreadFactory.newThread(new RunnableTask(1)).start();
	 }
}

package concurrency.servlet;

import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concurrency.task.RunnableTask;

//https://access.redhat.com/documentation/en-us/jboss_enterprise_application_platform_continuous_delivery/14/html/development_guide/concurrency_utilities
//http://localhost:8080/concurrency/TaskServlet
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
 private static final long serialVersionUID = 2452936659555107992L;

 private static final Logger LOG =
  Logger.getLogger(TaskServlet.class.getSimpleName());

 @Resource(lookup = "java:jboss/ee/concurrency/executor/Aula_Task")
 private ManagedExecutorService managedExecutorService;

 protected void doGet(HttpServletRequest request,
  HttpServletResponse response) throws ServletException, IOException {
  for (int i = 1; i <= 10; i++) {
   try {
    managedExecutorService.submit(new RunnableTask(i));
   } catch (RejectedExecutionException e) {
    LOG.info("O envio da task " + i + " para o pool foi rejeitado..");
   }
  }
 }

}
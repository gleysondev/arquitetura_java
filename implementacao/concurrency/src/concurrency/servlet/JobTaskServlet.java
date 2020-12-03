package concurrency.servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import concurrency.task.RunnableTask;

//http://localhost:8080/concurrency/JobTaskServlet
@WebServlet("/JobTaskServlet")
public class JobTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 2452936659555107992L;

	private static final Logger LOG = Logger.getLogger(JobTaskServlet.class.getSimpleName());

	@Resource(lookup = "java:jboss/ee/concurrency/scheduler/Aula_JobTask")
	private ManagedScheduledExecutorService managedScheduledExecutorService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.info("Executando agendamento..");
		//No nosso caso, a task aguardará 10 segundos até ser executada pela primeira vez 
		//e posteriormente será executada em intervalos fixos de 20 segundos
		managedScheduledExecutorService.scheduleAtFixedRate(new RunnableTask(1), 10, 20, TimeUnit.SECONDS);
	}

}
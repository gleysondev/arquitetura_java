package concurrency.task;

import java.util.logging.Logger;

public class RunnableTask implements Runnable {

	private static final Logger LOG = Logger.getLogger(RunnableTask.class.getSimpleName());
	private int index;

	public RunnableTask(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		LOG.info("Executando método run da classe RunnableTask(" + index + ")");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOG.info("Finalizando execução do método run da classe RunnableTask(" + index + ")");
	}

	@Override
	public String toString() {
		return "RunnableTask [index=" + index + "]";
	}

}
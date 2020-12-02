package util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesUtil {
	public static void mensagem(String id,Severity tipo, String titulo,String mensagem, String globalId) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage msg= new FacesMessage(tipo,titulo , mensagem);
		ctx.addMessage(id,msg);
		//https://stackoverflow.com/questions/19538125/jsf-hmessages-render-global-message-is-not-rerendered
		if(globalId!=null) {
			FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(globalId);
		}
	}
	public static void info(String id,String mensagem, String globalId) {
		mensagem(id,FacesMessage.SEVERITY_INFO, "Informação:", mensagem,globalId);
	}
	public static void aviso(String id,String mensagem, String globalId) {
		mensagem(id,FacesMessage.SEVERITY_WARN, "Atenção:", mensagem,globalId);
	}
	public static void erro(String id,String mensagem, String globalId) {
		mensagem(id,FacesMessage.SEVERITY_ERROR, "Erro:", mensagem,globalId);
	}
	
	public static void info(String mensagem, String globalId) {
		info(null, mensagem,globalId);
	}
	public static void info(String mensagem) {
		info(null, mensagem,"frm:msg");
	}
	public static void aviso(String mensagem) {
		aviso(null, mensagem,null);
	}
	public static void erro(String mensagem) {
		erro(null, mensagem,null);
	}
}

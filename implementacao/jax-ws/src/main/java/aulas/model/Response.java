package aulas.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {
	@XmlElement(name="item")
	private Object item;
	@XmlElement(name="error")
	private String error;
	@XmlElement(name="itens")
	private List itens;
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	public List getItens() {
		return itens;
	}
	public void setItens(List itens) {
		this.itens = itens;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getError() {
		return error;
	}
	public static Response ok(Object item) {
		Response response = new Response();
		response.setItem(item);
		return response;
	}
	public static Response ok(List itens) {
		Response response = new Response();
		response.setItens(itens);
		return response;
	}
	public static Response error(String error) {
		Response response = new Response();
		response.setError(error);
		return response;
	}
}

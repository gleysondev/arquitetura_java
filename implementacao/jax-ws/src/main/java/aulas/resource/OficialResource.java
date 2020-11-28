package aulas.resource;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import aulas.model.Oficial;
import aulas.model.Response;
import aulas.respository.OficialRepository;

@WebService
@SOAPBinding(style = Style.RPC)
public class OficialResource {
	private OficialRepository repository = new OficialRepository();

	@WebMethod(operationName = "getOficiais")
	//@WebResult(name = "response")
	public Response list() {
		return Response.ok(repository.getAll());
	}

	@WebMethod(operationName = "getOficial")
	//@WebResult(name = "response")
	public Response get(@WebParam(name = "id") Integer id) {
		return Response.ok(repository.get(id));
	}
	
	@WebMethod(operationName = "addOficial")
	//@WebResult(name = "response")
	public Response add(@WebParam(name = "oficial") Oficial oficial) {
		repository.add(oficial);
		return Response.ok(oficial);
	}
	@WebMethod(operationName = "editOficial")
	//@WebResult(name = "response")
	public Response edit(@WebParam(name = "oficial") Oficial oficial) {
		Oficial p = repository.get(oficial.getId());
        if(p == null)
            return Response.error("Edit Error");
		repository.add(oficial);
		return Response.ok(oficial);
	}
	@WebMethod(operationName = "deleteOficial")
	//@WebResult(name = "response")
	public Response delete(@WebParam(name = "id") Integer id) {
		Oficial p = repository.get(id);
        if(p == null)
            return Response.error("Delete Error");
        repository.delete(id);
		return Response.ok("Id was " + id + " was delete");
	}
}

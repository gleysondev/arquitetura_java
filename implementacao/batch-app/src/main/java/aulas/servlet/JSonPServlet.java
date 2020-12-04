package aulas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aulas.jsonp.JSonpExample;
//http://localhost:8080/batch-app/json-p
@WebServlet("/json-p")
public class JSonPServlet extends HttpServlet {


       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
    	   JSonpExample.sample();
       }
}
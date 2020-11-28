    <html>  
    <body>  
    <form action="cadastro.jsp" method="POST">  
      
    Nome:<input type="text" name="nome"/><br/><br/>  
    Posto:  
    <select name="posto">  
    <option>Marechal do Ar</option>  
    <option>Tenente-Brigadeiro do Ar</option>  
    <option>Major-Brigadeiro</option>  
    </select>  
      
    <br/><br/>  
    <input type="submit" value="cadastro"/>  
      
    </form>
    
    
		<% 
		String nome = request.getParameter("nome");
		
		String posto = request.getParameter("posto");
		
		if(nome!=null)
			out.print(String.format("O Oficial %s %s cadastrado com sucesso", nome, posto));  
		
		%>
      
    </body>  
    </html>  
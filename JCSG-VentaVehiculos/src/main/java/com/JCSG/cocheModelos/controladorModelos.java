package com.JCSG.cocheModelos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class controladorProductos
 */

@WebServlet("/controladorProductos")
public class controladorModelos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ModeloMod modeloMod;

    @Resource(name = "jdbc/jcsgcoches")
    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        super.init();

       try {
    	  modeloMod=new ModeloMod(miPool); 
       }catch(Exception e) {
    	   throw new ServletException(e);
       }
       
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String elComando=request.getParameter("instruccion");
    	
    	if(elComando==null) elComando="listar";
    	
    	switch(elComando) {
    	case "listar":
    		obtenerModelos(request, response);
    		break;
    	
    	case "insertarBBDD":
    		agregarModelos(request, response);
    		break;
    		
    	case "cargar":
    		try {
				cargaModelos(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		break;
    		
    	case "ActualizarBBDD":
    		try {
				actualizaModelos(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		break;
    		
    	case "eliminar":
    		try {
				eliminarModelo(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		break;
    	}
    	
    	   
    }
    

    

	private void eliminarModelo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String idEl = request.getParameter("IdModeloEliminar");
	    idEl = idEl.replaceAll("[^\\d]", "");
		System.out.println(idEl);
		modeloMod.eliminarProducto(idEl);
		obtenerModelos(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaDeModelos.jsp");
	    dispatcher.forward(request, response);
		
	}

	private void actualizaModelos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		int idAg=Integer.parseInt(request.getParameter("id"));
		String marcaAg=request.getParameter("marca");
		String modeloAg=request.getParameter("modelo");
		String motorAg=request.getParameter("motor");
		int potenciaAg=Integer.parseInt(request.getParameter("potencia"));
		
		SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		Date fechaRegistroAg=null;
		try {
			fechaRegistroAg=formatoFecha.parse(request.getParameter("fechaRegistro"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Modelos modeloActualizado=new Modelos(idAg, marcaAg, modeloAg, motorAg, potenciaAg, fechaRegistroAg);
		
		modeloMod.actualizarNuevoModelo(modeloActualizado);
		
		obtenerModelos(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaDeModelos.jsp");
	    dispatcher.forward(request, response);
		
		
	}

	private void cargaModelos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String idModelo=request.getParameter("IdModelo");
		System.out.println(idModelo);
		Modelos elModelo=modeloMod.getModelo(idModelo);
		request.setAttribute("codigoId", elModelo);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarModelo.jsp");
		dispatcher.forward(request, response);
		
	}

	private void agregarModelos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String marcaAg=request.getParameter("marca");
		String modeloAg=request.getParameter("modelo");
		String motorAg=request.getParameter("motor");
		int potenciaAg=Integer.parseInt(request.getParameter("potencia"));
		
		SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		Date fechaRegistroAg=null;
		try {
			fechaRegistroAg=formatoFecha.parse(request.getParameter("fechaRegistro"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Modelos nuevoModelo=new Modelos(marcaAg, modeloAg, motorAg, potenciaAg, fechaRegistroAg);
		
		try {
			modeloMod.agregarNuevoModelo(nuevoModelo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		obtenerModelos(request, response);
		
		
	}

	private void obtenerModelos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		List<Modelos> modelos;
	      try {
	    	  modelos=modeloMod.getModelos();
	    	  request.setAttribute("listaModelos", modelos);
	    	  RequestDispatcher miDispatcher=request.getRequestDispatcher("ListaDeModelos.jsp");
	    	  miDispatcher.forward(request, response);
	      }catch(Exception e) {
	    	  
	      }
		
	}

  
    
}


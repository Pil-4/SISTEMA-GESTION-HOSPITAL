package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicoDao;
import dao.impl.MedicoDaoImpl;
import models.Medico;
import utils.Util;

@WebServlet("/medicos-detalle/*")
public class MedicoDetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MedicoDao medicoDao;
 
    public MedicoDetalleServlet() {
        super();
        medicoDao = new MedicoDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String id = Util.extractDataFromPath(pathInfo, 1);
		System.out.println("id: "+id);
		
		Medico medico = medicoDao.obtenerMedico(Integer.parseInt(id));
		request.setAttribute("medico", medico);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/medicos-detalle.jsp");
		dispatcher.forward(request, response);
    }



}

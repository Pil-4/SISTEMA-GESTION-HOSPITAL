package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicoDao;
import dao.impl.MedicoDaoImpl;
import models.Medico;

@WebServlet("/medicos-listar")
public class MedicoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private MedicoDao medicoDao;
	
    public MedicoListarServlet() {
        super();
        medicoDao = new MedicoDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Medico> medicos = medicoDao.listarMedicos();
		
		request.setAttribute("medicos", medicos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/medicos-listar.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

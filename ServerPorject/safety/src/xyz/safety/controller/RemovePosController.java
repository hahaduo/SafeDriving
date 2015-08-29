package xyz.safety.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.safety.base.BaseUtil;
import xyz.safety.service.IDevPosService;
import xyz.safety.service.impl.DevPosServiceImpl;

/**
 * Servlet implementation class RemovePosController
 */
@WebServlet("/removePos")
public class RemovePosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String condition = BaseUtil.fixNull(request.getParameter("cdsn"));
		IDevPosService devPosService = new DevPosServiceImpl();
		long recode = devPosService.deleteByDate(condition);
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().append(String.valueOf(recode));
	}

}

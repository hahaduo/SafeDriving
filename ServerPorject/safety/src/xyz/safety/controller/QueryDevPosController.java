package xyz.safety.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.safety.service.IDevPosService;
import xyz.safety.service.impl.DevPosServiceImpl;
import xyz.safety.vo.DevPos;

/**
 * Servlet implementation class QueryDevPosController
 */
@WebServlet("/queryPos")
public class QueryDevPosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryDevPosController() {
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
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null){
			currentPage = "1";
		}
		int currentPageNum = Integer.parseInt(currentPage);
		
		IDevPosService devPosService = new DevPosServiceImpl();
		DevPos devpos = new DevPos();
		int totalCnt = devPosService.getTotalCntOfDevPos(devpos);
		
		devpos.setCurrentPageNum(currentPageNum);
		List<DevPos> list = devPosService.getDevPosList(devpos);
	
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("devPosList", list);
		request.getRequestDispatcher("devPosList.jsp").forward(request, response);
	}

}

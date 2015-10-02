package xyz.safety.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import xyz.safety.base.BaseUtil;
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
		String currentPage = BaseUtil.fixNull(request.getParameter("currentPage"));
		if("".equals(currentPage)){
			currentPage = "1";
		}
		int currentPageNum = Integer.parseInt(currentPage);
		String devId = BaseUtil.fixNull(request.getParameter("devId"));
		
		
		IDevPosService devPosService = new DevPosServiceImpl();
		DevPos devpos = new DevPos();
		devpos.setCurrentPageNum(currentPageNum);
		
		if(!"".equals(devId)){
			devpos.setDevId(devId);
		}
//		int totalCnt = devPosService.getTotalCntOfDevPosMongo(devpos);
		int totalCnt = devPosService.getTotalCntOfDevPos(devpos);

		
		List<DevPos> list = devPosService.getDevPosList(devpos);
//		List<Document> list = devPosService.getDevPosListMongo(devpos);
	
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("devId", devId);
		request.setAttribute("devPosList", list);
		request.getRequestDispatcher("devPosList.jsp").forward(request, response);
	}

}

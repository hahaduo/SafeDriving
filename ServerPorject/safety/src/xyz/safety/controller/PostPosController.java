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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class safety
 */
@WebServlet("/postPos")
public class PostPosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPosController() {
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
		String devJSON = request.getParameter("devData");
		int recode = 0; 
		if(devJSON !=null && !"".equals(devJSON)){
			Gson gson = new Gson();
			IDevPosService devPosService = new DevPosServiceImpl();
			if(devJSON.startsWith("[")){
				List<DevPos> devposlist = gson.fromJson(devJSON, new TypeToken<List<DevPos>>() {  
		        }.getType());
				recode = devPosService.batchSaveDevPos(devposlist);
			}else{
				DevPos devpos= gson.fromJson(devJSON, DevPos.class);
				recode = devPosService.saveDevPos(devpos);
			}
		}
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().append(String.valueOf(recode));
	}

}

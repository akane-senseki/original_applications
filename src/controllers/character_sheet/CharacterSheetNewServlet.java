package controllers.character_sheet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pc_Entity;

/**
 * Servlet implementation class CharacterSheetNewServlet
 */
@WebServlet("/charactersheet/new")
public class CharacterSheetNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharacterSheetNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("pc_entity", new Pc_Entity());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/characterSheet/new.jsp");
        rd.forward(request, response);

    }

}

package controllers.character_sheet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pc_Entity;
import utils.DBUtil;

/**
 * Servlet implementation class CharacterSheetIndexServlet
 */
@WebServlet("/charactersheet/index")
public class CharacterSheetIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharacterSheetIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<Pc_Entity> pc_entity = em.createNamedQuery("getAllPc_Entity",Pc_Entity.class).getResultList();

        em.close();

        request.setAttribute("pc_entity",pc_entity);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/characterSheet/index.jsp");
        rd.forward(request, response);
    }

}

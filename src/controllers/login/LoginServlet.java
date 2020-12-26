package controllers.login;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //認証結果を格納する変数
        Boolean check_result = false;

        String sigin_mail = request.getParameter("sigin_mail");
        String sigin_password = request.getParameter("sigin_password");

        User u = null;

        if (sigin_mail != null && !sigin_mail.equals("") && sigin_password != null && !sigin_password.equals("")) {
            EntityManager em = DBUtil.createEntityManager();

            String password = EncryptUtil.getPasswordEncrypt(
                    sigin_password,
                    (String) this.getServletContext().getAttribute("pepper"));

            //メールアドレスとパスワードが正しいかチェックする
            try {
                u = em.createNamedQuery("checkLogin", User.class)
                        .setParameter("mail", sigin_mail)
                        .setParameter("pass", password)
                        .getSingleResult();
            } catch (NoResultException ex) {
            }

            em.close();

            if (u != null) {
                check_result = true;
            }

            if(!check_result){
                //認証出来なかったらflushでメッセージを表示する
                request.setAttribute("_token",request.getSession().getId());
                request.getSession().setAttribute("flush", "ログインに失敗しました");
                request.setAttribute("mail", sigin_mail);

                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.forward(request, response);
            }else{
                //認証できたらログイン状態にしてトップページへリダイレクト
                request.getSession().setAttribute("login_user", u);

                request.getSession().setAttribute("flush", "ログインしました。");
                response.sendRedirect(request.getContextPath()+"/index.html");
            }

        }

    }

}

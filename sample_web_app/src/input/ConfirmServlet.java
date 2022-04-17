package input;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class InputServlet
 */
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 入力値取得
		String text = request.getParameter("inputName");

		// レスポンス情報セット
		HttpSession session = request.getSession();
		session.setAttribute("confirmName", text);
		// confirm.jspを表示する
		response.sendRedirect("confirm.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 入力値取得
		String name = request.getParameter("inputName");
		String tel = request.getParameter("inputTel");
		String birth = request.getParameter("inputBirthday");
		String gender = request.getParameter("inputGender");
		String mail = request.getParameter("inputMail");

		//入力チェック
		boolean errFlg = false;
		if(StringUtils.isEmpty(name)) {
			request.setAttribute("errMsg", "氏名を入力してください");
			errFlg = true;
		}
		if(name.length()>20) {
			request.setAttribute("errMsg", "氏名は20文字以内で入力してください");
			errFlg = true;
		}
		//エラーの場合画面再表示
		if(errFlg) {
			// index.jspを表示する
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		// レスポンス情報セット
		request.setAttribute("confirmName", name);
		request.setAttribute("confirmTel", tel);
		request.setAttribute("confirmBirthday", birth);
		request.setAttribute("confirmGender", gender);
		request.setAttribute("confirmMail", mail);
		// confirm.jspを表示する
		request.getRequestDispatcher("confirm.jsp").forward(request, response);
	}

}

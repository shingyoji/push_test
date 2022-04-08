package input;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// request.jspから送られてきたテキストを受け取りtextという変数に入れる
		String text = request.getParameter("inputName");
		if(StringUtils.isEmpty(text)) {
			request.setAttribute("errMsg", "氏名を入力してください");

			// confirm.jspを表示する
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		// response.jspで文字列を取得するための準備
		request.setAttribute("confirmName", text);

		// confirm.jspを表示する
		request.getRequestDispatcher("confirm.jsp").forward(request, response);
	}

}

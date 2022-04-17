package input;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InputDao;
import dao.entity.User;

/**
 * Servlet implementation class InputServlet
 */
public class CompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InputDao inputDao = new InputDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteServlet() {
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
		// 入力値取得
		String name = request.getParameter("compName");
		String tel = request.getParameter("compTel");
		String birth = request.getParameter("compBirthday")+" 00:00:00";
		String gender = request.getParameter("compGender");
		String mail = request.getParameter("compMail");

		try{

			//入力チェック

			//ユーザーID取得
			List<Integer> userids = inputDao.selectUserid();
			//生年月日設定
			DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date uDate = format1.parse(birth) ;
			//システム日時取得
			Date date = new Date(System.currentTimeMillis());

			//登録情報設定
			User user = new User();
			user.setUserid(uniqueId(userids));
			user.setName(name);
			user.setTel(tel);
			user.setBirthday(Date.valueOf(format.format(uDate)));
			user.setGender(gender);
			user.setMail(mail);
			user.setInsdate(date);
			user.setUpddate(date);

			//ユーザー情報登録
			inputDao.userInsert(user);

			// confirm.jspを表示する
			request.getRequestDispatcher("complete.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			// index.jspを表示する
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	private int uniqueId(List<Integer> userids) {
		int uniqueId = 0;
		Random random = new Random();
		boolean success = false;
		while (!success) {
			success =true;
			uniqueId = random.nextInt(100000000);
			for(int id:userids) {
				if(uniqueId == id) {
					success =false;
					break;
				}
			}
		}
		return uniqueId;
	}

}

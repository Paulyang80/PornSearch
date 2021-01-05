import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestFinalProject
 */
@WebServlet("/FinalProject")
public class FinalProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinalProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if (request.getParameter("keyword") == null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			return;
		}
		GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));

		HashMap<String, String> query = google.query();

		String[][] s = new String[query.size() + 4][2];
		request.setAttribute("query", s);

		int num = 0;
		float[] sum = new float[30];
		String[] keys = new String[30];
		String[] values = new String[30];
		for (Entry<String, String> entry : query.entrySet()) {
			String key = entry.getKey(); // title
			String value = entry.getValue(); // URL

			if (value.contains("pornhub.com") == false) {
				// 算權重關鍵字出現幾次
				WordCounter c = new WordCounter(value);

				// add keyword
				LinkedList<Keyword> list = new LinkedList<Keyword>();
				list.add(new Keyword("性暴力", c.countKeyword("性暴力"), 5));
				list.add(new Keyword("Sexual violence", c.countKeyword("Sexual violence"), 5));
				list.add(new Keyword("性虐待", c.countKeyword("性虐待"), 3));
				list.add(new Keyword("Sexual abuse", c.countKeyword("Sexual abuse"), 3));
		  		list.add(new Keyword("未成年", c.countKeyword("未成年"), 1));
				list.add(new Keyword("Teenager", c.countKeyword("Teenager"), 1));
				list.add(new Keyword("Pornhub", c.countKeyword("Pornhub"), 5));

				// 所有權重算出來的總合
				float total = 0;
				for (int i = 0; i < list.size(); i++) {
					total += list.get(i).score();
				}

				sum[num] = total;
				keys[num] = key;
				values[num] = value;

				num++;
			}
		}

		// 加入指定網頁
		WordCounter2 c1 = new WordCounter2("換日線Pornhub",
				"/url?q=https://crossing.cw.com.tw/blogSearch.action?key=pornhub");
		sum[num] = c1.sum();
		keys[num] = c1.getTitle();
		values[num] = c1.getUrl();
		num++;

		WordCounter2 c2 = new WordCounter2("CNNPornhub", "/url?q=https://edition.cnn.com/search?q=pornhub");
		sum[num] = c2.sum();
		keys[num] = c2.getTitle();
		values[num] = c2.getUrl();
		num++;

		WordCounter2 c3 = new WordCounter2("BBCPornhub", "/url?q=https://www.bbc.co.uk/search?q=pornhub");
		sum[num] = c3.sum();
		keys[num] = c3.getTitle();
		values[num] = c3.getUrl();
		num++;

		WordCounter2 c4 = new WordCounter2("TheKoreaTimesPornhub",
				"/url?q=https://www.koreatimes.co.kr/www2/common/search.asp?kwd=pornhub");
		sum[num] = c4.sum();
		keys[num] = c4.getTitle();
		values[num] = c4.getUrl();
		num++;

		SearchSort so = new SearchSort(sum, keys, values);
		so.doSort();

		for (int i = 0; i < num; i++) {
			s[i][0] = keys[i];
			s[i][1] = values[i];
		}

		request.getRequestDispatcher("NewsItem.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
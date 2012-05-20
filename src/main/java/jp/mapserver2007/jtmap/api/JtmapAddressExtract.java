package jp.mapserver2007.jtmap.api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JtmapAddressExtract extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// デコードする文字コードを指定
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータ取得
		String content  = request.getParameter("content");
		String apikey   = request.getParameter("apikey");
		String callback = request.getParameter("callback");
		// メイン処理
		JtmapExecute jtmap_api = new JtmapExecute();
		String json = jtmap_api.extract(content, apikey, callback);
		response.setContentType("application/javascript; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(json);
	}
}

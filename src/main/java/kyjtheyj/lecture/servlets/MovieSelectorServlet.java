package kyjtheyj.lecture.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@WebServlet("/movie/recommendationTest")
public class MovieSelectorServlet extends HttpServlet {
    private final List<String> movieTitles = List.of("쇼생크 탈출", "타이타닉", "대부", "메멘토");

    // JSON 파싱을 해주는 ObjectMapper
    private final ObjectMapper mapper = new ObjectMapper();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int randomIndex = new Random().nextInt(movieTitles.size());
        String movieTitle = movieTitles.get(randomIndex);

        HashMap<String, String> movieMap = new HashMap<>();
        movieMap.put("title", movieTitle);

        // JSON 형식으로 String 파싱
        String jsonStr = mapper.writeValueAsString(movieMap);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonStr);
    }
}

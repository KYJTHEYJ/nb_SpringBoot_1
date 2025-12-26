package kyjtheyj.lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class MovieSelectController {
    @GetMapping("/movies")
    public String movies(Model model) {
        final List<String> movieTitles = List.of("쇼생크 탈출", "타이타닉", "대부", "메멘토");

        String randomMovieTitle = getRandomMovieTitle(movieTitles);

        model.addAttribute("movieTitle", randomMovieTitle);
        return "movies";
    }

    private String getRandomMovieTitle(List<String> movieTitles) {
        int randomIndex = new Random().nextInt(movieTitles.size());
        return movieTitles.get(randomIndex);
    }
}

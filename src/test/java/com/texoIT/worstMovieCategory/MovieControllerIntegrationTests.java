package com.texoIT.worstMovieCategory;

import com.texoIT.worstMovieCategory.model.Movie;
import com.texoIT.worstMovieCategory.service.MovieServiceImpl;
import junit.framework.Assert;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest(
        classes = {WorstMovieCategoryApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MovieControllerIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Before
    public void setUp() {
        Movie mockMovieWinner1 = new Movie(1, 1982, "Inchon",
                Arrays.asList("MGM"),
                Arrays.asList("Mitsuharu Ishii"), Boolean.TRUE);

        Movie mockMovieWinner3 = new Movie(2, 1986, "Howard the Duck",
                Arrays.asList("Universal Studios"),
                Arrays.asList("Gloria Katz"), Boolean.TRUE);

        Movie mockMovieWinner4 = new Movie(3, 1986, "Under the Cherry Moon",
                Arrays.asList("Warner Bros."),
                Arrays.asList("Bob Cavallo", "Joe Ruffalo and Steve Fargnoli"), Boolean.TRUE);

        Movie mockMovieWinner2 = new Movie(4, 1980, "Can't Stop the Music",
                Arrays.asList("Associated Film Distribution"),
                Arrays.asList("Allan Carr"), Boolean.FALSE);

        Movie mockMovieWinner5 = new Movie(5, 2001, "Driven",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Renny Harlin", "Elie Samaha and Sylvester Stallone"), Boolean.TRUE);

        Movie mockMovieWinner6 = new Movie(6, 1982, "Inchon",
                Arrays.asList("MGM"),
                Arrays.asList("Renny Harlin"), Boolean.TRUE);

        Movie mockMovieWinner7 = new Movie(7, 1995, "Showgirls",
                Arrays.asList("MGM", "United Artists"),
                Arrays.asList("Charles Evans and Alan Marshall", "Joe Ruffalo and Steve Fargnoli"), Boolean.TRUE);

        Movie mockMovieWinner8 = new Movie(8, 1996, "Driven",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Charles Evans and Alan Marshall", "Elie Samaha and Sylvester Stallone"), Boolean.TRUE);

        Movie mockMovieWinner9 = new Movie(9, 2001, "Thundercats",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Renny Harlin", "Elie Samaha and Sylvester Stallone"), Boolean.FALSE);

        Movie mockMovieWinner10 = new Movie(10, 2017, "Driven",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Renny Harlin"), Boolean.TRUE);

        movieServiceImpl.getListMovies().clear();
        movieServiceImpl.getListMovies().add(mockMovieWinner1);
        movieServiceImpl.getListMovies().add(mockMovieWinner2);
        movieServiceImpl.getListMovies().add(mockMovieWinner3);
        movieServiceImpl.getListMovies().add(mockMovieWinner4);
        movieServiceImpl.getListMovies().add(mockMovieWinner5);

    }

    @Test
    public void testFindProducersStatistics() throws JSONException {
        Movie mockMovieWinner1 = new Movie(6, 1982, "Inchon",
                Arrays.asList("MGM"),
                Arrays.asList("Renny Harlin"), Boolean.TRUE);

        Movie mockMovieWinner2 = new Movie(7, 1995, "Showgirls",
                Arrays.asList("MGM", "United Artists"),
                Arrays.asList("Charles Evans and Alan Marshall", "Joe Ruffalo and Steve Fargnoli"), Boolean.TRUE);

        Movie mockMovieWinner3 = new Movie(8, 1996, "Driven",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Charles Evans and Alan Marshall", "Elie Samaha and Sylvester Stallone"), Boolean.TRUE);

        Movie mockMovieWinner4 = new Movie(9, 2001, "Thundercats",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Renny Harlin", "Elie Samaha and Sylvester Stallone"), Boolean.FALSE);

        Movie mockMovieWinner5 = new Movie(10, 2017, "Driven",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Renny Harlin"), Boolean.TRUE);

        movieServiceImpl.getListMovies().clear();
        movieServiceImpl.getListMovies().add(mockMovieWinner1);
        movieServiceImpl.getListMovies().add(mockMovieWinner2);
        movieServiceImpl.getListMovies().add(mockMovieWinner3);
        movieServiceImpl.getListMovies().add(mockMovieWinner4);
        movieServiceImpl.getListMovies().add(mockMovieWinner5);

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/producers"),
                HttpMethod.GET, entity, String.class);

        String expected = "{"
                + "\"min\":"
                + "{\"producer\":\"Charles Evans and Alan Marshall\","
                + "\"interval\":1,"
                + "\"previousWin\":1995,"
                + "\"followingWin\":1996},"
                + "\"max\":"
                + "{\"producer\":\"Renny Harlin\","
                + "\"interval\":35,"
                + "\"previousWin\":1982,"
                + "\"followingWin\":2017}"
                + "}";

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}

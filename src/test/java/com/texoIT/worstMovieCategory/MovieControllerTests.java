package com.texoIT.worstMovieCategory;

import com.texoIT.worstMovieCategory.controller.MovieController;
import com.texoIT.worstMovieCategory.model.Movie;
import com.texoIT.worstMovieCategory.service.MovieServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieServiceImpl movieServiceImpl;

    @Test
    public void testGetProducersStatistics() throws Exception {
        Movie mockMovieWinner1 = new Movie(1, 1982, "Inchon",
                Arrays.asList("MGM"),
                Arrays.asList("Renny Harlin"), Boolean.TRUE);

        Movie mockMovieWinner2 = new Movie(2, 1995, "Showgirls",
                Arrays.asList("MGM", "United Artists"),
                Arrays.asList("Charles Evans and Alan Marshall", "Joe Ruffalo and Steve Fargnoli"), Boolean.TRUE);

        Movie mockMovieWinner3 = new Movie(3, 1996, "Driven",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Charles Evans and Alan Marshall", "Elie Samaha and Sylvester Stallone"), Boolean.TRUE);

        Movie mockMovieWinner4 = new Movie(4, 2001, "Thundercats",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Renny Harlin", "Elie Samaha and Sylvester Stallone"), Boolean.FALSE);

        Movie mockMovieWinner5 = new Movie(5, 2017, "Driven",
                Arrays.asList("Warner Bros.", "Franchise Pictures"),
                Arrays.asList("Renny Harlin"), Boolean.TRUE);

        List<Movie> list = new ArrayList<>();
        list.add(mockMovieWinner1);
        list.add(mockMovieWinner2);
        list.add(mockMovieWinner3);
        list.add(mockMovieWinner4);
        list.add(mockMovieWinner5);

        Mockito.when(movieServiceImpl.getListMovies()).thenReturn(list);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/producers")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());

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

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}

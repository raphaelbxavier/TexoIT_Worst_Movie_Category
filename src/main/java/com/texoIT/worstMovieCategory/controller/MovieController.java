package com.texoIT.worstMovieCategory.controller;

import com.texoIT.worstMovieCategory.model.Producer;
import com.texoIT.worstMovieCategory.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @GetMapping("/producers")
    public ResponseEntity<Object> findProducersStatistics() {
        HashMap<String, List<Integer>> mapProducerYears = new HashMap<>();
        Producer producer = new Producer();

        movieServiceImpl.getListMovies().stream()
                .filter(m -> m.getIsWinnerMovie())
                .forEach(a -> {
                    for (String b : a.getProducers()) {
                        List<Integer> aux = mapProducerYears.get(b);
                        if (aux == null) {
                            aux = new LinkedList<>();
                            aux.add(a.getYearMovie());
                            mapProducerYears.put(b, aux);
                        } else {
                            aux.add(a.getYearMovie());
                            mapProducerYears.put(b, aux);
                        }
                    }
                });

        List<Producer.Item> list = new ArrayList<>();
        mapProducerYears.entrySet().stream()
                .filter(m -> m.getValue().size() > 1)
                .forEach(i -> {

                    Producer.Item minItem = null;
                    List<Integer> aux = i.getValue();
                    Integer min = null, previous = null, next = null, diff = null;

                    for (int a = 0; a < (aux.size() - 1); a++) {
                        previous = aux.get(a);
                        next = aux.get(a + 1);
                        diff = next - previous;
                        if (min == null) {
                            min = diff;
                        } else if (min > diff) {
                            min = diff;
                        }
                    }

                    minItem = new Producer.Item(i.getKey(), diff, previous, next);
                    list.add(minItem);
                });

        Producer.Item minByInterval = list
                .stream()
                .min(Comparator.comparing(Producer.Item::getInterval))
                .orElseThrow(NoSuchElementException::new);

        list.clear();
        mapProducerYears.entrySet().stream()
                .filter(m -> m.getValue().size() > 1)
                .forEach(i -> {

                    Producer.Item minItem = null;
                    List<Integer> aux = i.getValue();
                    Integer max = null, previous = null, next = null, diff = null;

                    for (int a = 0; a < (aux.size() - 1); a++) {
                        previous = aux.get(a);
                        next = aux.get(a + 1);
                        diff = next - previous;
                        if (max == null) {
                            max = diff;
                        } else if (max < diff) {
                            max = diff;
                        }
                    }

                    minItem = new Producer.Item(i.getKey(), diff, previous, next);
                    list.add(minItem);
                });

        Producer.Item maxByInterval = list
                .stream()
                .max(Comparator.comparing(Producer.Item::getInterval))
                .orElseThrow(NoSuchElementException::new);

        producer.setMin(minByInterval);
        producer.setMax(maxByInterval);
        return ResponseEntity.status(HttpStatus.OK).body(producer);
    }
}

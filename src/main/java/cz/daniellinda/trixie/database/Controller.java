package cz.daniellinda.trixie.database;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Controller {
    @Autowired
    private ObceRep obceRep;

    private static ObceRep rep;

    @PostConstruct
    private void init() {
        rep = obceRep;
    }

    public static void saveObce(List<Obce> iterable) {
        rep.saveAll(iterable);
    }

}

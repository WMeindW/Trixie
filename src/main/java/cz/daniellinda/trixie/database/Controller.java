package cz.daniellinda.trixie.database;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Controller {
    @Autowired
    private ObceRep obceRep;

    private static ObceRep orep;

    @Autowired
    private CastObceRep castObceRepo;

    private static CastObceRep crep;

    @PostConstruct
    private void init() {
        orep = obceRep;
        orep.deleteAll();
        crep = castObceRepo;
        crep.deleteAll();
    }

    public static void saveObce(List<Obce> iterable) {
        orep.saveAll(iterable);
    }

    public static void saveCastObce(List<CastObce> iterable) {
        crep.saveAll(iterable);
    }

}

package cmdVersion.game.questionFactory.animeComparator;

import connection.Anime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class startDateAnimeComparator implements Comparator<Anime> {

    @Override
    public int compare(Anime o1, Anime o2) {
        String animeStrDate1 = o1.get_start_date();
        String animeStrDate2 = o2.get_start_date();

        LocalDate animeDate1 = LocalDate.parse(animeStrDate1, DateTimeFormatter.ISO_DATE);
        LocalDate animeDate2 = LocalDate.parse(animeStrDate2, DateTimeFormatter.ISO_DATE);

        return animeDate2.compareTo(animeDate1);
    }
}

package cmdVersion.game.questionFactory.animeComparator;

import connection.Anime;
import java.util.Comparator;

// Rating rank determines the "Community approval rate"
public class ratingRankAnimeComparator implements Comparator<Anime> {
    @Override
    public int compare(Anime o1, Anime o2) {
        return o2.get_rating_rank()-o1.get_rating_rank();
    }
}

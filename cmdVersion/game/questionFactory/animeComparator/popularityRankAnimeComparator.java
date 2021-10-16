package cmdVersion.game.questionFactory.animeComparator;

import connection.Anime;
import java.util.Comparator;

// Popularity tells the well-known-ness of the anime like odd taxi got 15000 on popularity rank but 150 on rating rank
public class popularityRankAnimeComparator implements Comparator<Anime> {
    @Override
    public int compare(Anime o1, Anime o2) {
        return o2.get_popularity_rank()-o1.get_popularity_rank(); // Positive when anime1 has a better rank than anime2
    }
}

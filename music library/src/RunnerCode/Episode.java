//TIANA KOUNDAKJIAN 260949364
package RunnerCode;

import java.util.Objects;

/**
 * Represents a single episode, with at least a title, and an episode number.
 */
public class Episode implements PlayInsidePlaylist {

    private final Podcast aPodcast;
    private final String aTitle;
    private final int aEpisodeNumber;

    /**
     * Creates an episode
     *
     * @param pPodcast
     *            RunnerCode.Podcast that this episode is a part of
     * @param pTitle
     *            title of the episode
     * @param pEpisodeNumber
     *            the episode number that identifies the episode
     * @pre   pPodcast != null && pTitle!=null
     * @throws IllegalArgumentException
     */

    Episode(Podcast pPodcast, String pTitle, int pEpisodeNumber) {
        assert (pPodcast != null) && (pTitle != null);
        aPodcast = pPodcast;
        aTitle = pTitle;
        aEpisodeNumber = pEpisodeNumber;
        aPodcast.addEpisode(this);
    }


    // prevents creation of same episode twice. flyweight pattern. checks
    public static Episode makeAnEpisode(Podcast pPodcast, String pTitle, int pEpisodeNumber) {
        assert (pPodcast != null) && (pTitle != null) && (pEpisodeNumber > 0);
        Episode newEp = new Episode(pPodcast, pTitle, pEpisodeNumber);
        if (pPodcast.getEpisode(pTitle,pEpisodeNumber) == null) {
            return newEp;//return-create new episode
        }
        return pPodcast.getEpisode(pTitle,pEpisodeNumber);//returns old episode
    }


    protected Podcast getaPodcast() {
        return aPodcast;
    }

    protected String getaTitle() {
        return aTitle;
    }

    protected int getaEpisodeNumber() {
        return aEpisodeNumber;
    }

    @Override
    public void play() {
        System.out.println("Now playing " + aPodcast.getName().toLowerCase() + " [" + aEpisodeNumber + "]: " + aTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode = (Episode) o;
        return aEpisodeNumber == episode.aEpisodeNumber && Objects.equals(aPodcast, episode.aPodcast) && Objects.equals(aTitle.toLowerCase(), episode.aTitle.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(aPodcast, aTitle,aEpisodeNumber);
    }

}


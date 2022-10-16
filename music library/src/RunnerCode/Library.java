//TIANA KOUNDAKJIAN 260949364
package RunnerCode;

import java.util.HashSet;
import java.util.Optional;

/**
 * Represents an Audio library, with individual RunnerCode.Song titles, Podcasts and playlists.
 */
public class Library {

    /**
     * Adds your design of fields for RunnerCode.Library
     **/
    //fields for library characterization
    private String name= "";
    //used optional for description!
    private Optional<String> description;
    //flieds to avoid duplicates- keep track of elements contained in lib
    private static final HashSet<Playable> playableHashSet = new HashSet<>();
    private static final HashSet<Podcast> podcastHashSet = new HashSet<>();
    private static Library INSTANCE ;

    /** CONSTRUCTOR**/
    //SINGLETON - PRIV COSTRUCTOR)
    private Library(String name)
    {
        this.name = name;
    }
    //overloading constructor
    private Library(String name,Optional<String> description )
    {
        this.name = name;
        this.description= description.empty();
    }

    //returns instance
    public static Library instance()
    {
        return INSTANCE;
    }

    //make a lib with singleton - Same reference. Only 1 library.
    public static Library makeNewLib(String name){
        if (INSTANCE==null){
            INSTANCE= new Library(name);
        }
        return INSTANCE;

    }
    /**
     * Adds a RunnerCode.Song to the library. Duplicate Songs aren't added twice.
     *
     * @param pSong the RunnerCode.Song to add
     */
    public void addSong(Song pSong) {
        assert pSong!=null;
        playableHashSet.add(pSong);
    }

    /**
     * Adds a RunnerCode.PlayList to the library.
     * All Songs from the list are also added as individual Songs to the library.
     *
     * @param pList
     *            the RunnerCode.PlayList to add
     * @pre pList!=null;
     */
    public void addPlayList(PlayList pList) {
        assert pList!=null;
        playableHashSet.add(pList);
    }

    /**
     * Adds a RunnerCode.Podcast to the library.
     * All Episodes from the list are also added as individual episodes to the library.
     *
     * @param pPodcast
     *            the RunnerCode.Podcast to add
     * @pre pPodcast!=null;
     */
    public void addPodcast(Podcast pPodcast) {
        assert pPodcast!=null;
        podcastHashSet.add(pPodcast);
        for (Episode ep: pPodcast.getEpisodeList()){
            playableHashSet.add(ep);
        }


    }

    /**
     * REMOVES a RunnerCode.Song to the library. Duplicate Songs aren't added twice.
     *
     * @param pSong the RunnerCode.Song to add
     */
    public void removeSong(Song pSong) {
        assert pSong!=null;
        playableHashSet.remove(pSong);
    }

    /**
     * REMOVES a RunnerCode.PlayList to the library.
     * All Songs from the list are also added as individual Songs to the library.
     *
     * @param pList
     *            the RunnerCode.PlayList to add
     * @pre pList!=null;
     */
    public void removePlayList(PlayList pList) {
        assert pList!=null;
        playableHashSet.remove(pList);
    }

    /**
     * REMOVES a RunnerCode.Podcast to the library.
     * All Episodes from the list are also REMOVED as individual episodes from the library.
     *
     * @param pPodcast
     *            the RunnerCode.Podcast to add
     * @pre pPodcast!=null;
     */
    public void removePodcast(Podcast pPodcast) {
        assert pPodcast!=null;

        for (Episode ep: pPodcast.getEpisodeList()){
            playableHashSet.remove(ep);
        }
        podcastHashSet.remove(pPodcast);

    }


}

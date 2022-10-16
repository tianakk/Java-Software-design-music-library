//TIANA KOUNDAKJIAN 260949364
package RunnerCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a sequence of playables to play in FIFO order.
 */
public class PlayList implements Playable {

    //I DONT WANT A PLAYLIST TO CONTAIN A PLAYLIST

    private final List<Playable> aList = new LinkedList<>();
    private String aName;
    private int aNext;

    /**
     * Creates a new empty playlist.
     *
     * @param aName
     *            the name of the list
     * @pre aName!=null;
     */
    public PlayList(String aName) {
        assert aName != null;
        this.aName = aName;
        aNext = 0;

    }

    /**
     * Adds a playable at the end of this playlist.
     *
     * @param pPlayable
     *            the content to add to the list
     * @pre pPlayable!=null;
     */
    public void addPlayable(Playable pPlayable) {
        assert pPlayable != null;
        aList.add(pPlayable);

    }

    //removes Playable from playlist
    public void removePlayable(Playable pPlayable) {
        assert pPlayable != null;
        aList.remove(pPlayable);

    }


    //checks element and sequence for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return aList.equals(playList.aList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aList);
    }


    @Override
    public void play() {

    }

}
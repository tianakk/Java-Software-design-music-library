//TIANA KOUNDAKJIAN 260949364
package RunnerCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a single RunnerCode.Song, with at least a title, and an artist name.
 */
public class Song implements PlayInsidePlaylist{

    private String aTitle;
    private String aArtist;
    private static HashMap<Song,Song> songHash= new HashMap();

    /**
     * Creates a RunnerCode.Song.
     * Add your constructor here
     * flyweight
     */
    private Song(String aArtist, String aTitle){
        assert (aArtist!=null)&&(aTitle!=null);
        this.aArtist=aArtist;
        this.aTitle=aTitle;

    }

    // FLYWEIGHT PATTERN
    public static Song flySong (String aName, String aTitle){
        Song newSong= new Song(aName,aTitle);
        if ( songHash.get(newSong)==null){
            songHash.put(newSong,newSong);
            return newSong;}

        else{
            return songHash.get(newSong) ;}
    }




    public void play() {
        // Just a stub.
        // We don't expect you to implement an actual music player!
        System.out.println("Now playing " + aTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;

        //insensitive
        return Objects.equals(aTitle.toLowerCase(), song.aTitle.toLowerCase()) && Objects.equals(aArtist.toLowerCase(), song.aArtist.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(aTitle, aArtist);
    }
}
//TIANA KOUNDAKJIAN 260949364
import RunnerCode.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TASK: Write runner code to show your work

        //MAKING SONGS USING FLYWEIGHT
        Song S1= Song.flySong("Adele","Oh My God");
        Song S2= Song.flySong("Adele","Hello");
        Song S3dup= Song.flySong("Adele","Oh My God");
        Song S4= Song.flySong("ABBA","Mamma Mia");

        //MAKING PODCAST WITH FLYWEIGHT
        Podcast P1= Podcast.flyPodcast("The art of giving","Nathan");
        Podcast P2= Podcast.flyPodcast("The art of happiness","Maria");
        Podcast P3= Podcast.flyPodcast("The art of love","Diana");
        Podcast P4dup= Podcast.flyPodcast("The art of giving","Nathan");


        //MAKING EPISODE WITH FLYWEIGHT
        Episode E1= Episode.makeAnEpisode(P1,"welcome",1);
        Episode E2dup= Episode.makeAnEpisode(P1,"welcome",1);
        Episode E3= Episode.makeAnEpisode(P1,"pilot",4);
        Episode E4= Episode.makeAnEpisode(P1,"Right",3);
        Episode E5= Episode.makeAnEpisode(P3,"Up",6);
        Episode E6= Episode.makeAnEpisode(P2,"Up",6);

        //the episode E1 shouldnt be added above, already exists
        P1.addEpisode(E1);
        P1.addEpisode(E4);
        P1.addEpisode(E1);
        P1.addEpisode(E3);
        //ADD TO P3
        P3.addEpisode(E5);
        P3.addEpisode(E1);//E1 will not be added because E1 is in podcast p1- illegal arg exception

        //ADDING SONGS AND PODCATS TO PLAYLIST
        PlayList playList = new PlayList("personal dev");
        playList.addPlayable(S1);
        playList.addPlayable(S2);
        playList.addPlayable(P1.getEpisode("pilot",4));
        playList.addPlayable(P1.getEpisode("welcome",1));
        playList.addPlayable(P1.getEpisode("Right",3));

        //MAKE LIB WITH SINGLETON. THERE'S ONLY 1
        Library lib = Library.makeNewLib("myLib");
        lib.addPlayList(playList);
        lib.addPodcast(P3);
        lib.addPodcast(P1);
        lib.addSong(S2);


        System.out.println("TEST CASE 1: FLYWEIGHT: check if 2 songs equal, 2 podcast equal - same reference/ NO DUPLICATES------------------------------");
        System.out.println("songs");
        System.out.println("S1==S2?");
        System.out.println(S1==S2);
        System.out.println("S1==S3dup?");
        System.out.println(S1==S3dup);
        System.out.println("podcast");
        P2.addEpisode(E6);
        System.out.println("P3==P2?");
        System.out.println(P3==P2);
        System.out.println("P3==P1?");
        System.out.println(P3==P1);
        System.out.println("P1==P2?");
        System.out.println(P1==P2);
        System.out.println("P1==P4dup?");
        System.out.println(P1==P4dup);

        System.out.println("End of TESTCASE1 ---------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("TEST CASE 2: FLYWEIGHT: check for PLAYLISTS equal-------------------------------------------");
        //MAKING NEW PLAYLIST
        PlayList playList11 = new PlayList("hi");
        playList11.addPlayable(S1);
        playList11.addPlayable(S2);
        playList11.addPlayable(P1.getEpisode("pilot",4));
        playList11.addPlayable(P1.getEpisode("welcome",1));
        playList11.addPlayable(P1.getEpisode("Right",3));
        //MAKE ANOTHER PLAYLIST
        PlayList playList2 = new PlayList("banana");
        playList2.addPlayable(S1);

        System.out.println("playList AND (playList11)- SAME ELEMENTS, SAME ORDER?");
        System.out.println(playList.equals(playList11));
        System.out.println("playList AND (playList2)- SAME ELEMENTS, SAME ORDER?");
        System.out.println(playList.equals(playList2));

        System.out.println();

        System.out.println("End of TESTCASE2 ---------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");


        System.out.println("TEST CASE 3:  SINGLETON : Check singleton of LIB - bool=true - because same reference--------");
        Library library2= Library.makeNewLib("lib2");
        System.out.println("lib==library2 ? -SAME REFERENCE?");
        System.out.println(lib==library2);
        System.out.println("End of TESTCASE 3 --------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");






    }


}

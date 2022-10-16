//TIANA KOUNDAKJIAN 260949364
package RunnerCode;

import java.util.*;

/**
 * Represents a single RunnerCode.Podcast, with at least a name and a host.
 * Each RunnerCode.Podcast aggregates episodes.
 */


public class Podcast {

    private String aName;
    private String aHost;

    private List<Episode> aEpisodes = new ArrayList<>();
    private static HashMap<Podcast,Podcast> podcastHash= new HashMap<>();

    /**
     * Creates a RunnerCode.Podcast
     * Add your constructor below
     * Flyweight
     */

    private Podcast (String aName, String aHost){
        assert (aHost!=null)&&(aName!=null);
        this.aHost=aHost;
        this.aName=aName;

    }


    //FLYWEIGHT PATTERN- FACTORY METHOD
    public static Podcast flyPodcast (String aName, String aHost){
        Podcast newPod= new Podcast(aName,aHost);
        if ( podcastHash.get(newPod)==null){
            podcastHash.put(newPod,newPod);
            return newPod;}

        else{
        return podcastHash.get(newPod) ;}
    }


    //TRADEOFF - chose the make episode in episode class
//    public Episode makesEpisode(Podcast pPodcast, String pTitle, int pEpisodeNumber){
//        assert pPodcast!=null;//has to belong to a podcast
//        Episode epi= new Episode(pPodcast,pTitle,pEpisodeNumber);
//        return epi;
//    }

    /**
     * Add one episode to the podcast
     * @param pEpisode to be put into the podcast
     * @pre
     */
    public void addEpisode(Episode pEpisode) {
        assert pEpisode.getaPodcast()== this;//make sure it has a podcast
        //need to check if podcasts are the same, if not dont add
        if(!aEpisodes.contains(pEpisode)) {
            aEpisodes.add(pEpisode);
        }
    }
    protected void removeEpisode(Episode pEpisode) {
        //check ep not null
        if(aEpisodes.contains(pEpisode)) {
            aEpisodes.remove(pEpisode);
        }
    }

    /**
     * retrieve one episode from the podcast
     * @param pIndex
     *
     */

    protected Episode getEpisodeNum(int pIndex) {
        return aEpisodes.get(pIndex);
    }

    //gets list, used in add podcast and remove podcast in Livrary class
    protected List<Episode> getEpisodeList() {
        ArrayList<Episode>newEpList= new ArrayList<>();
        for (Episode ep: aEpisodes){
            newEpList.add((Episode) ep);}
        return newEpList;
    }

    //searches ep in podcast
    public Episode getEpisode(String title, int num) {
        for (Episode ep : this.aEpisodes){
            if (ep.getaEpisodeNumber()== num){
                if (ep.getaTitle().equals(title)){
                    return ep;
                }
            }
        }
        return null;
    }

    public String getName() {
        return aName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Podcast podcast = (Podcast) o;
        return Objects.equals(aName.toLowerCase(), podcast.aName.toLowerCase()) && Objects.equals(aHost.toLowerCase(), podcast.aHost.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(aName, aHost);
    }

    protected String getaHost() {
        return aHost;
    }

}
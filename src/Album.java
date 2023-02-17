import java.util.*;
public class Album {
    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSong(List<Song> song) {
        this.songs = song;
    }
    //find
    boolean findSong(String  title){
        for(Song song: songs){
            if(song.getTitle().equals(title))
                return true;
        }
        return false;
    }
    //add Song
    String addSong(String title,double duration){

        if(findSong(title)==false){
            Song s = new Song(title,duration);
            songs.add(s);
            return "Song added to the album";
        }
        else
            return "Song already exists";
    }
    String addToPlaylistFromALbum(String title, List<Song> playList){
        if(findSong(title)==true){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    playList.add(s);
                    return "Song added to your playList";
                }
            }
        }
        return "Song not present in Albums";
    }
    String addToPlaylistFromALbum(int trackNo, List<Song> playList){
        int pos = trackNo-1;
        if(pos>=0 && pos<this.songs.size()){
            playList.add(this.songs.get(pos));
            return "Song added to playList";
        }
        else
            return "Invalid position of the song";
    }
}

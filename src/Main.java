import java.util.*;
public class Main {
    public static void main(String[] args) {
        Album a1 = new Album("Bacardi","Ritviz");
        a1.addSong("song1", 4.0);
        a1.addSong("song2",3.56);

        Album a2 = new Album("choo lo","local train");
        a2.addSong("choo lo",3.2);
        a2.addSong("khudi",4.1);

        List<Song> myPlaylist = new LinkedList<>();
        System.out.println(a2.addToPlaylistFromALbum("khudi",myPlaylist));
        a1.addToPlaylistFromALbum(2,myPlaylist);
        a1.addToPlaylistFromALbum(1,myPlaylist);

        play(myPlaylist);
        }
        public static void play(List<Song> playList){

        ListIterator<Song> itr = playList.listIterator();
        if(playList.size()==0){
                System.out.println("Empty playlist");
                return;
            }

            boolean isNext;

            System.out.println("Currently playing:");
            System.out.println(itr.next());
            isNext = true;

            Scanner s = new Scanner(System.in);
            System.out.println("Enter your choice");
            printMenu();
            while(true){
                int choice = s.nextInt();
                
                switch(choice){
                    case 1 :
                        if(!isNext)
                            System.out.println(itr.next());

                        if(itr.hasNext()){
                            System.out.println("Now Playing");
                            System.out.println(itr.next());
                            isNext = true;
                        }
                        else System.out.println("You have reached the end");
                        break;
                    case 2:
                        if(isNext)
                            System.out.println(itr.previous());

                        if(itr.hasPrevious()){
                            System.out.println("Now Playing");
                            System.out.println(itr.previous());
                            isNext = false;
                        }
                        else System.out.println("You are on first class already");
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        printAllSongs(playList);
                        break;
                    case 6:
                        printMenu();
                        break;
                    case 7:
                        return;
                }
            }
    }
    static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play prev song");
        System.out.println("3. Play curr song again");
        System.out.println("4. Delete curr song");
        System.out.println("5. Show all songs");
        System.out.println("6. Show menu");
        System.out.println("7. Exit");
    }
    static void printAllSongs(List<Song> playList){
        for(Song song: playList)
            System.out.println(song);
    }
}
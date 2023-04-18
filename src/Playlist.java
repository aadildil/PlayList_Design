import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Playlist {
    private String title;
    private List<Song> songs;

    public ListIterator<Song> itr;

    public boolean isNext;

    public Playlist(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
        itr=songs.listIterator();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String addSongFromAlbum(Album album, String songTitle)
    {
        Optional<Song> optionalSongAlbum=album.findSong(songTitle);
        if(optionalSongAlbum.isEmpty())
            return "Song not found";
        Optional<Song> optionalSongPlaylist=findSong(songTitle);
        if(optionalSongPlaylist.isPresent())
            return "song already present in the playlist";
        else {
            songs.add(optionalSongAlbum.get());
            itr= songs.listIterator();
            return "song added successfully";
        }
    }
    public String addSongFromAlbum(Album album,int trackNo)
    {
        Optional<Song> optionalSongAlbum=album.findSong(trackNo);
        if(optionalSongAlbum.isEmpty())
            return "Song not found";
        Optional<Song> optionalSongPlaylist=findSong(optionalSongAlbum.get().getTitle());
        if(optionalSongPlaylist.isPresent())
            return "song already present in the playlist";

        else {
            songs.add(optionalSongAlbum.get());
            itr= songs.listIterator();
            return "song added successfully";
        }
    }
    public Optional<Song> findSong(String title)
    {
        for(Song song:songs)
        {
            if(title.equals(song.getTitle()))
            {
                return Optional.of(song);
            }

        }
        return Optional.empty();
    }

    public Optional<Song> findSong(int trackNo)
    {
       if(trackNo>=0&&trackNo<=songs.size())
       {
           return Optional.of(songs.get(trackNo-1));
       }
       else
           return Optional.empty();
    }

    public String playCurrentSong()
    {

      if(isNext)
      {
          isNext=false;
          return "Playing : "+itr.previous();
      }
        isNext=true;
        return "Playing : "+itr.next();

    }
    public String playPreviousSong()
    {

        if(isNext)
        {
            itr.previous();
            isNext=false;
        }
        if(itr.hasPrevious())
        {
            isNext=false;
            return "Playing previous song : "+itr.previous();
        }
        return "reached start of the playlist";

    }
    public String playNextSong()
    {

        if(!isNext)
        {
            itr.next();
            isNext=true;
        }
        if(itr.hasNext())
        {
            isNext=true;
            return "Playing next song : "+itr.next();
        }
        return "you reached end of playlist";
    }
}

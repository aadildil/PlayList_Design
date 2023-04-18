public class Main {
    public static void main(String[] args) {

        Album albumKL=new Album("To pimp a butterfly","Kendrick Lamar");
        albumKL.addSong(new Song("King Kunta",albumKL.getArtist(),235));
        albumKL.addSong(new Song("Hood Politics",albumKL.getArtist(),293));
        albumKL.addSong(new Song("These walls",albumKL.getArtist(),301));

        Album albumW=new Album("After Hours","Weekend");
        albumW.addSong(new Song("Save Your Tears",albumW.getArtist(),216));
        albumW.addSong(new Song("In Your Eyes",albumW.getArtist(),238));
        albumW.addSong(new Song("Heartless",albumW.getArtist(),198));

        Playlist playlist=new Playlist("Liked Songs");
        playlist.addSongFromAlbum(albumW,2);
        playlist.addSongFromAlbum(albumKL,2);
        playlist.addSongFromAlbum(albumKL,3);
        playlist.addSongFromAlbum(albumKL,"King Kunta");
        playlist.addSongFromAlbum(albumW,"Save Your Tears");

        System.out.println(  playlist.playCurrentSong());
        System.out.println(playlist.playNextSong());
        System.out.println(playlist.playNextSong());
        System.out.println(playlist.playNextSong());
        System.out.println(playlist.playPreviousSong());
        System.out.println(playlist.playPreviousSong());
        System.out.println(playlist.playPreviousSong());
        System.out.println(playlist.getSongs().size());





    }
}
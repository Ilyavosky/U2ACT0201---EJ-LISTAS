package utils;

import models.musicPlayer;
import java.util.LinkedList;

public class playerUtils {
    private LinkedList<musicPlayer> playlist;
    private int currentSongIndex;

    public playerUtils() {
        this.playlist = new LinkedList<>();
        this.currentSongIndex = 0; // Empezamos en la primera canción
    }



    public void addSong(musicPlayer songToAdd) {
        this.playlist.add(songToAdd);
        System.out.println("Canción agregada: " + songToAdd.getTitle());
    }

    public void nextSong(){
        if (this.playlist.isEmpty()){
            System.out.println("La playlist está vacía");
            return;
        }
        this.currentSongIndex ++;
        if (this.currentSongIndex == this.playlist.size()){
            this.currentSongIndex = 0;
        }
    }

    public void previousSong(){
        if (this.playlist.isEmpty()){
            System.out.println("La playlist está vacía");
            return;
        }
        this.currentSongIndex --;
        if (this.currentSongIndex < 0){
            this.currentSongIndex = this.playlist.size() - 1;
        }
    }

    public void deleteCurrentSong(){
        if (this.playlist.isEmpty()){
            System.out.println("La playlist está vacía, no hay nada que eliminar");
            return;
        }
        musicPlayer songToDelete = this.playlist.get(this.currentSongIndex);
        this.playlist.remove(this.currentSongIndex);
        System.out.println("Canción eliminada: " + songToDelete.getTitle());
        if (this.playlist.isEmpty()) {
            this.currentSongIndex = 0;
        }
    }

    public void currentSong(){
        if (this.playlist.isEmpty()){
            System.out.println("No hay canciones en la playlist, no se está reproduciendo nada");
            return;
        }
        musicPlayer currentSong = this.playlist.get(this.currentSongIndex);
        System.out.println("Canción actual: " + currentSong.getTitle() + "-" + currentSong.getArtist());
    }

    public void showFullPlaylist(){
        if (this.playlist.isEmpty()){
            System.out.println("No hay canciones en la playlist");
            return;
        }
        System.out.println("Playlist completa:");
        for (musicPlayer song : this.playlist){
            System.out.println(song);
        }
    }

    public void randomPlayer(){

    }
}



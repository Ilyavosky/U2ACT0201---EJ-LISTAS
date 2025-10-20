package models;
/*
Ejercicio 2: Playlist Musical Circular
Crea una playlist de música que funcione como una lista circular, donde después de la última canción automáticamente
regrese a la primera. La playlist debe permitir:
Agregar canciones (título y artista)
Reproducir la siguiente canción
Reproducir la canción anterior
Eliminar la canción actual
Mostrar la canción que está reproduciéndose
Mostrar todas las canciones en la playlist
Reto adicional: Implementa un método "modo aleatorio" que reproduzca canciones en orden aleatorio sin repetir
hasta que se hayan reproducido todas.
*/
public class musicPlayer {
    private String title;
    private String artist;
    private boolean isPlaying;
    private boolean hasBeenPlayed;

    public  musicPlayer() {}

    public musicPlayer(String title, String artist, boolean isPlaying, boolean hasBeenPlayed) {
        this.title = title;
        this.artist = artist;
        this.isPlaying = isPlaying;
        this.hasBeenPlayed = hasBeenPlayed;
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

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isHasBeenPlayed() {
        return hasBeenPlayed;
    }

    public void setHasBeenPlayed(boolean hasBeenPlayed) {
        this.hasBeenPlayed = hasBeenPlayed;
    }

    @Override
    public String toString() {
        return "musicPlayer{" +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", isPlaying=" + isPlaying +
                ", hasBeenPlayed=" + hasBeenPlayed +
                '}';
    }
}

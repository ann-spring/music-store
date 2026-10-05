package musicstore;

import java.util.Objects;

public class Album {
    private final String title;
    private final String artist;
    private final int year;
    private final double price;

    public Album(String title, String artist, int year, double price) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (artist == null || artist.isEmpty()) {
            throw new IllegalArgumentException("Artist cannot be empty");
        }
        if (year < 1900 || year > 2100) {
            throw new IllegalArgumentException("Year must be between 1900 and 2100");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getYear() { return year; }
    public double getPrice() { return price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return year == album.year
                && Double.compare(album.price, price) == 0
                && Objects.equals(title, album.title)
                && Objects.equals(artist, album.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, year, price);
    }

    @Override
    public String toString() {
        return "Album{" + title + " by " + artist + " (" + year + "), " + price + "}";
    }
}

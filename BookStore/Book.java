package BookStore;

import java.util.*;

// class "Book" start

class Book {
    int id;
    String title;
    String author;
    boolean isAvailable;
    double totalRatingPoints;
    int numRatings;
    String review;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.totalRatingPoints = 0.0;
        this.numRatings = 0;
        this.review = "";
    }

    public double getAverageRating() {
        if (numRatings == 0) {
            return 0.0;
        }
        return totalRatingPoints / numRatings;
    }
}

// class "Book" end
package three.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Show implements Serializable {
    private int showId;
    private String showTitle;
    private int numSeasons;
    private int initialYear;

    public Show(){
        super();
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public int getNumSeasons() {
        return numSeasons;
    }

    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }

    public int getInitialYear() {
        return initialYear;
    }

    public void setInitialYear(int initialYear) {
        this.initialYear = initialYear;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ")
                .add(showId+"")
                .add(showTitle)
                .add(numSeasons+"")
                .add(initialYear+"")
                .toString();
    }
}

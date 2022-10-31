import java.time.LocalDateTime;

public class JobPosition {
    private final LocalDateTime publishedDate;
    private final String title;
    private final boolean isRemote;
    private String description;
    private String location;
    private double salaryCap;
    private int yearsOfExperience;

    @Override
    public String toString() {
        return "Title: " + title + System.lineSeparator() +
                "published date: " + publishedDate + System.lineSeparator() +
                "remote: " + isRemote + System.lineSeparator() +
                "description: " + description + System.lineSeparator() +
                "location: " + location + System.lineSeparator() +
                "salary cap: " + salaryCap + System.lineSeparator() +
                "years of experience required: " + yearsOfExperience;
    }

    public static class Builder {
        private final LocalDateTime publishedDate;
        private final String title;
        private final boolean isRemote;
        private String description = "job description";
        private String location = "Tel Aviv";
        private double salaryCap = 50000;
        private int yearsOfExperience = 3;

        public Builder(LocalDateTime publishedDate, String title, boolean isRemote) {
            this.publishedDate = publishedDate;
            this.title = title;
            this.isRemote = isRemote;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder salaryCap(double salaryCap) {
            this.salaryCap = salaryCap;
            return this;
        }

        public Builder yearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public JobPosition build() {
            return new JobPosition(this);
        }
    }

    public JobPosition(Builder builder) {
        this.publishedDate = builder.publishedDate;
        this.title = builder.title;
        this.isRemote = builder.isRemote;
        this.description = builder.description;
        this.location = builder.location;
        this.salaryCap = builder.salaryCap;
        this.yearsOfExperience = builder.yearsOfExperience;
    }
}

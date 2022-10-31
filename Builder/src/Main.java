import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        JobPosition fullStackDeveloper=new JobPosition.Builder(LocalDateTime.now(),"Full Stack Developer", true)
                .description("experienced full stack developer")
                .location("Ra'anana")
                .salaryCap(35000)
                .yearsOfExperience(4)
                .build();
        System.out.println(fullStackDeveloper);
    }
}
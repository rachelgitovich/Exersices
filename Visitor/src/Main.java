import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<JsonClass> jsonClasses=new ArrayList<>();
        jsonClasses.add(new User(1,"Rachel","123"));
        jsonClasses.add(new Asset(123,"Rachel",1));
        jsonClasses.add(new Group(456,50));
        JsonVisitor jsonVisitor=new JsonVisitor();
        for(JsonClass jsonClass: jsonClasses){
            System.out.println(jsonClass.accept(jsonVisitor));
        }
    }
}
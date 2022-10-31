import com.google.gson.Gson;

public class JsonVisitor implements Visitor {
    private static final Gson gson = new Gson();

    @Override
    public String visit(User user) {
        return gson.toJson(user);
    }

    @Override
    public String visit(Asset asset) {
        return gson.toJson(asset);
    }

    @Override
    public String visit(Group group) {
        return gson.toJson(group);
    }
}
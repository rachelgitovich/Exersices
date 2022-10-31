public interface Visitor {
    String visit(User user);
    String visit(Asset asset);
    String visit(Group group);
}
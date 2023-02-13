package Task1;

public enum Type {
    WORK("рабочие задачи"), PERSONAL("личные задачи");
    private String type;

    Type(String type) {
        this.type = type;
    }

    public void  values(Task task) {
        for (Type t : Type.values()) {
            System.out.println(t);
       Type.valueOf("рабочие задачи");
    }

    //public static Type valuesOf(String s) {
       // Type a = Type.valueOf("рабочие задачи");
       // return a;
    }

}

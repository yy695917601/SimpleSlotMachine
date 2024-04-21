package simpleSlotMachine;

import java.util.ArrayList;

public class Icon {
    private String apple = "\uD83C\uDF4E";
    private String cherries = "\uD83C\uDF52";
    private String banana = "\uD83C\uDF4C";
    private String lemon = "\uD83C\uDF4B";
    private String hundred = "\uD83D\uDCAF";
    private ArrayList<String> icon = new ArrayList<>();

    public ArrayList<String> getIcon() {
        return icon;
    }

    public Icon() {
        icon.add(apple);
        icon.add(banana);
        icon.add(cherries);
        icon.add(lemon);
        icon.add(hundred);
    }
}

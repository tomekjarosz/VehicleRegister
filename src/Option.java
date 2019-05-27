public enum Option {

    EXIT(0, "wyjście z programu"),
    REGISTER_VEHICLE(1, "rejestracja nowego pojazdu"),
    DISPLAY_VEHICLES(2, "pokaż zarejestrowane pojazdy");

    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static Option createFromInt (int option){
        return Option.values()[option]; //to nic innego jak pozycja "option" z domyślnej tablicy "values" :-)
    }
}

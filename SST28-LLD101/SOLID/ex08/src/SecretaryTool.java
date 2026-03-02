public class SecretaryTool implements Secretary {

    private final MinutesBook minutesBook;


    public SecretaryTool(MinutesBook minutesBook) {
        this.minutesBook = minutesBook;
    }


    @Override
    public void addMinutes(String text) {
        minutesBook.add(text);
    }
}

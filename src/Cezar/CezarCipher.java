package Cezar;

public class CezarCipher{

    private static final char[] ALPHA = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public boolean isValidKey(int key, char[] alpha) {
        return false;
    };
    public boolean isFileExists(String filePath) {
        return false;
    }

    public String readFile(String filePath) {
        return filePath;
    }
    public void writeFile(String content, String filePath) {}
}

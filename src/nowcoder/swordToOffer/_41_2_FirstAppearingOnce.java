package nowcoder.swordToOffer;


public class _41_2_FirstAppearingOnce {
    private StringBuffer str = new StringBuffer();
    private int[] hash = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch) {
        str.append(ch);
        hash[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char ch : str.toString().toCharArray()
                ) {
            if (hash[ch] == 1)
                return ch;
        }
        return '#';
    }

    public static void main(String[] args) {
        String test = "googLeLLL";
        _41_2_FirstAppearingOnce obj = new _41_2_FirstAppearingOnce();
        for (char ch : test.toCharArray()
                ) {
            obj.Insert(ch);
        }
        System.out.println(obj.FirstAppearingOnce());
    }
}

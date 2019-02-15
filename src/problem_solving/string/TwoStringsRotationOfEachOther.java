package problem_solving.string;

public class TwoStringsRotationOfEachOther {

    public static void main(String[] args) {
        check2StringsRotationOfEachOther("ravi", "arar");
    }

    private static void check2StringsRotationOfEachOther(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return;
        }

        String s3 = s1 + s2;
        // if s2 is a substring of s3 then true else false
    }

}

package problem_solving.string;

public class TwoStringsRotationOfEachOther {

    public static void main(String[] args) {
        boolean b = check2StringsRotationOfEachOther("ravi", "vira");
        System.out.println(b);
    }

    private static boolean check2StringsRotationOfEachOther(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String s3 = s1 + s1;
        // if s2 is a substring of s3 then true else false
        if(s3.contains(s2)){
            return true;
        }
        return false;
    }

}

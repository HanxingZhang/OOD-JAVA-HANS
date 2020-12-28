package Strings;

public class ReverseOrder {

    public static void main(String[] args) {
        ReverseOrder r = new ReverseOrder();
        String result = r.reverseOrder("asdqdwq!@##$$!$&*$1231@*$Hha$(@$88(");
        System.out.println(result);
    }

    public String reverseOrder(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = length - 1; i >= 0; i--) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt((i))).append("-");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

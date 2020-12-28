public class PatternRecognition {
    public String patternRecognition(String input) {
        String[] inputs = input.split("\\;");
        String pattern = inputs[0];
        String[] blobs = inputs[1].split("\\|");
        StringBuilder sb = new StringBuilder();
        int total = 0;
        for(String blob: blobs) {
            int count = 0;
            if(pattern != null && pattern.length() > 0) {
                count = countPattern(blob, pattern);
            }
            sb.append(String.valueOf(count)).append("|");
            total += count;
        }
        sb.append(String.valueOf(total));
        return sb.toString();
    }

    private int countPattern(String blob, String pattern) {
        int lastIndex = 0;
        int count = 0;
        int length = pattern.length();
        for(int i = 0; i < blob.length() - length + 1; i++) {
            if(pattern.equals(blob.substring(i, i + length))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PatternRecognition s = new PatternRecognition();
        // 3|2|1|2|8
        System.out.println(s.patternRecognition("bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
        // 4|4|2|0|10
        System.out.println(s.patternRecognition("aa;aaaakjlhaa|aaadsaaa|easaaad|sa"));
        //4|2|3|2|11
        System.out.println(s.patternRecognition("b;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
        // 0|0|0|0|0
        System.out.println(s.patternRecognition(";bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
    }
}

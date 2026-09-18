

class ValidAnagram{
    public static void main(String[] args) {
        String s = "aab";
        String t = "aba";
        System.out.println(isAnagramFreqCounting(s,t));

    }

    //check if anagram
    public static boolean isAnagramBF(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        char[] sArr = s.toCharArray();
        for(char c : sArr){
            String str = c+"";
            if(t.contains(str)){
                t = t.replaceFirst(str, "");
            } else{
                return false;
            }
        }
        if(t.isEmpty()){
            return true;
        }

        return false;
    }

    public static boolean isAnagramFreqCounting(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        //count chars in s
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            freq[t.charAt(i)-'a']--;
        }

        //chk all freqs
        for(int count : freq){
            if(count != 0){
                return false;
            }
        }

        return false;
    }
}
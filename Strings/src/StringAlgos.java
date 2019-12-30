class StringAlgos {

    public static void main(String[] args) {
        String newstring = new StringAlgos().reverseRecursiveString("123456789");
        System.out.println(newstring);
    }

    void checkAnagram(String s1, String s2){
        System.out.println(s1.substring(0, 1));
    }

    void printPermutation(String s){
        printPermutationUtil("", s);
    }

    void printPermutationUtil(String word, String s){
        if(s.length() == 1)
            System.out.println(word + s);


        for(int i = 0; i < s.length();i++){
            String substring = s.substring(0,i) + s.substring(i+1);
            String newword = word + s.charAt(i);
            printPermutationUtil(newword, substring);
        }

    }

    void reverseiterative(String s){
        char [] ch = s.toCharArray();
        for(int i = 0; i < ch.length/2; i++){
            char temp = ch[i];
            ch[i] = ch[ch.length-1-i];
            ch[ch.length-1-i] = temp;
        }
        System.out.println(new String(ch));
    }

    void reverseRecursive(String s){
        if(s.length() == 1) {
            System.out.println(s);
            return;
        }

        reverseRecursive(s.substring(1));
        System.out.println(s.charAt(0));
    }

    String reverseRecursiveString(String s){
        if(s.length() == 1)
            return s;

        return reverseRecursiveString(s.substring(1)) + s.charAt(0);
    }
}
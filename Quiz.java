public class Quiz {
    private static String[]question = {"3, 1, 4, 1, 5 ... ",
            "1, 1, 2, 3, 5 ... ", "1, 4, 9, 16, 25 ... ",
            "2, 3, 5, 7, 11 ... ", "1, 2, 4, 8, 16 ... "};
    private static int[] answer = {9, 8, 36, 13, 32};

     public String getQuestion(int index) {
        return question[index];
    }

    public int getAnswer(int index) {
        return answer[index];
    }

}

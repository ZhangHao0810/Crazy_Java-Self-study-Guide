package 反射_渡一教育.IOC;

/**
 * @author ZhangHao
 * @date 2019/10/9 18:54
 * @Description：
 */
public class Question {

    private String title;
    private String answer;

    Question() {

    }

    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

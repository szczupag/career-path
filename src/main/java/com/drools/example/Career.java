package com.drools.example;
import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Career {

    public static enum Answer {YES, NO, MAYBE};

    public static class CurrentQuestion{
        public Question question;

        public CurrentQuestion(Question question){
            this.question = question;
        }

        public Question getQuestion() {
            return question;
        }

        public void setQuestion(Question question) {
            this.question = question;
        }
    }

    public static class Question{
        public String questionText;
        public Answer answer;
        public Integer index;
        public Boolean enableMaybe;

        public Question(String questionText, Integer index) {
            this.questionText = questionText;
            this.index = index;
        }

        public String toString() {
            return questionText;
        }

        public void setAnswer(Answer answer) {
            this.answer = answer;
        }

        public void setEnableMaybe(Boolean enableMaybe) {
            this.enableMaybe = enableMaybe;
        }

        public Boolean getEnableMaybe() {
            return enableMaybe;
        }

        public Answer getAnswer() {
            return answer;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }

    public static class Solution{
        public String solutionText;

        public Solution(String solutionText){
            this.solutionText = solutionText;
        }
    }

    public static void main(String[] args) throws DroolsParserException, IOException {
        Career career = new Career();
        career.executeCareerRules();
    }

    public void executeCareerRules() throws IOException, DroolsParserException {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(Career.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession session = kContainer.newKieSession("ksession-rules");
        session.fireAllRules();
    }

}
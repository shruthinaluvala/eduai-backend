package com.eduai.model;

public class AiScore {

    private int total;
    private int accuracy;
    private int clarity;
    private int examples;
    private int structure;

    public AiScore() {}

    public AiScore(int accuracy, int clarity, int examples, int structure) {
        this.accuracy = accuracy;
        this.clarity = clarity;
        this.examples = examples;
        this.structure = structure;
        this.total = accuracy + clarity + examples + structure;
    }

    public int getTotal() {
        return total;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getClarity() {
        return clarity;
    }

    public int getExamples() {
        return examples;
    }

    public int getStructure() {
        return structure;
    }
}

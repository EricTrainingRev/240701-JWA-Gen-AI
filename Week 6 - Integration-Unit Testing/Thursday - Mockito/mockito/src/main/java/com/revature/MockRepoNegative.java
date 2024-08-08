package com.revature;

public class MockRepoNegative extends Repo{
    @Override
    public String getPerson(String input) {
        throw new CustomException("How did you get here?");
    }
}

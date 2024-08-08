package com.revature;

public class MockRepo extends Repo {
    @Override
    public String getPerson(String input) {
        return "Sally found!";
    }
}

package com.revature;

public class Service {

    private Repo repo;

    public Service(Repo repo){
        this.repo = repo;
    }

    public String getValidPeople(String input){
        if ("Billy".equals(input)){
            throw new CustomException("Billy's information is restricted!");
        }
        return repo.getPerson(input);
    }

}

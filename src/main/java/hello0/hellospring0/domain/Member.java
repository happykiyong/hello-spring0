package hello0.hellospring0.domain;

public class Member {
    private Long id;
    private String name;

    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
}

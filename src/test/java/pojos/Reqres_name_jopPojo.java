package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Reqres_name_jopPojo {
    private  String name;
    private String job;

    public Reqres_name_jopPojo(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public Reqres_name_jopPojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Reqres_name_jopPojo{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

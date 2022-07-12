package org.example.utilities;

public class SuperHeroe {
    Integer id;
    String name;
    String description;

    public SuperHeroe(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SuperHeroe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

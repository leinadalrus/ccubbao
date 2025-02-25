package ent.darriwills.qbao.models;

import jakarta.persistence.Entity;
import jakarta.persistent.GeneratedValue;
import jakarta.persistent.Id;

@Entity
public class Products {
    @Id @Generated private Long id;
    private String name;
    private String description;

    private String heroImage;
    private String dateStamp;

    public Products(String name,
        String description,
        String heroImage,
        String dateStamp
    ) {
        this.name = name;
        this.description = description;
        this.heroImage = heroImage;
        this.dateStamp = dateStamp;
    }

    public Products() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public String getDateStamp() {
        return dateStamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHeroImage(String heroImage) {
        this.heroImage = heroImage;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }

    @Override
        public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Products))
            return false;

        Products product = (Product) o;

        return Objects.equals(this.id, product.id)
            && Objects.equals(this.name, product.name)
            && Objects.equals(this.dateStamp, product.dateStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.dateStamp);
    }

    @Override
    public String toString() {
        return "Products{" + "id=" + this.id + ", name=" + this.name + "'\'"
            + ", dateStamp=" + this.dateStamp + "}";
    }
}
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")

public class City {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private List<Employee> employeeList;

    public City() {}
    public City(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }
    public City(String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @Override
    public String toString() {
        return "City: " +
                "id города =" + cityId +
                ", Название ='" + cityName + '\'';
    }
}
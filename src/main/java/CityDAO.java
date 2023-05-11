import java.util.Collection;

public interface CityDAO {
    Collection<City> getAllCity();

    City getCityById(int cityId);

    void createCity(City city);

    void updateCity(City city);

    void deleteCity(int cityId, City city);
}
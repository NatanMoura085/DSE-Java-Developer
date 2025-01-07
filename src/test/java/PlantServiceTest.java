import org.example.domain.DAO.PlantDAO;
import org.example.domain.model.Plant;
import org.example.domain.service.PlantService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class PlantServiceTest {

    @Test
    public void testAddPlant() throws SQLException {
        PlantDAO mockDAO = mock(PlantDAO.class);
        PlantService service = new PlantService(mockDAO);

        Plant plant = new Plant(101, "Rose");

        // Simula o comportamento do DAO
        doNothing().when(mockDAO).insertPlant(plant);

        service.addPlant(plant);
        verify(mockDAO, times(1)).insertPlant(plant);
    }

    @Test
    public void testDeletePlant() throws SQLException {
        PlantDAO mockDAO = mock(PlantDAO.class);
        PlantService service = new PlantService(mockDAO);

        Plant plant = new Plant(101, "Rose");

        doNothing().when(mockDAO).deletePlant(101);

        service.deletePlant(101, true);
        verify(mockDAO, times(1)).deletePlant(101);
    }
}

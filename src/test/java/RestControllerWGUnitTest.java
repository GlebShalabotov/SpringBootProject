import be.ucll.herexamen.Application;
import be.ucll.herexamen.controller.RestControllerWG;
import be.ucll.herexamen.model.MyService;
import be.ucll.herexamen.model.Werkgever;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(secure = false)
@RunWith(SpringRunner.class)
@WebMvcTest(RestControllerWG.class)

public class RestControllerWGUnitTest {

    @Autowired
    private MockMvc werkgeverController;

    @MockBean
    private MyService myService;

    @Test
    public void  when_asked_for_all_the_werkgever_give_back_json() throws Exception {

        Werkgever wg = WerkgeverBuilder.anOKWerkgever().build();
        List<Werkgever> werkgeversList = new ArrayList<>();
        werkgeversList.add(wg);
       Mockito.when(myService.findAllWerkgevers()).thenReturn(werkgeversList);

        werkgeverController.perform(get("/werkgever")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name").value("Elise"));

    }
}

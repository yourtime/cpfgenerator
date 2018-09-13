package com.example.demo;

import com.example.demo.cpfgenerator.CpfController;
import com.example.demo.cpfgenerator.CpfTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private CpfTest mockTest;
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        this.mockTest = mock(CpfTest.class);
        mvc = MockMvcBuilders.standaloneSetup(new CpfController(this.mockTest)).build();
    }

    @Test
    public void cpfgeneratorshouldreturnavalidvalue() throws Throwable {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/api/cpf/generator")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", equalTo(200)));

    }

}

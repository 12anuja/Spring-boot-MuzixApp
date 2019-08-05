package com.stackroute.MuzixApp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.error.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.service.MuzixSrevice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
public class MuzixControllerTest
{

        @Autowired
        private MockMvc mockMvc;
        private Muzix muzix;
        @MockBean
        private MuzixSrevice muzixSrevice;
        @InjectMocks
        private MuzixController muzixController;

        private List<Muzix> list =null;

        @Before
        public void setUp(){

            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(muzixController).build();
            muzix = new Muzix();
            muzix.setTrackId(1);
            muzix.setTrackName("How Long");
            muzix.setComment("Charle Puth");
            list = new ArrayList();

            list.add(muzix);
        }

        @Test
        public void saveTrackSuccess() throws Exception {
            when(muzixSrevice.saveTrack(any())).thenReturn(muzix);
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andDo(MockMvcResultHandlers.print());

        }

//        @Test
//        public void saveUserFailure() throws Exception {
//            when(muzixSrevice.saveTrack(any())).thenThrow(TrackAlreadyExistsException.class);
//            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
//                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
//                    .andExpect(MockMvcResultMatchers.status().isConflict())
//                    .andDo(MockMvcResultHandlers.print());
//        }

        @Test
        public void getAllUserSuccess() throws Exception {
            when(muzixSrevice.getAllTrack()).thenReturn(list);
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/get")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());

        }


        private static String asJsonString(final Object obj)
        {
            try{
                return new ObjectMapper().writeValueAsString(obj);

            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }

    }

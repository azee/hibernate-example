package com.mycompany.hibernate;

import com.mycompany.hibernate.entities.ExampleEntity;
import com.mycompany.hibernate.repositories.ExampleDalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:test-context.xml")
public class ExampleEntityTest {
    @Autowired
    ExampleDalService exampleDalService;

    @Test
    public void testCreation() throws Exception {
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setName("Ent1");
        exampleEntity.setUploaded(new Date().getTime());
        exampleDalService.updateEntity(exampleEntity);

        assertTrue("Can't persist an object", exampleDalService.countEntities() > 0);

        List<ExampleEntity> gotEntities = exampleDalService.getAllEntities();
        assertTrue("Number of persisted objects is not correct", gotEntities.size() == 1);
        assertTrue("Wrong name of the 1-st entity", "Ent1".equals(gotEntities.get(0).getName()));
    }
}

package cruadapp.service;

import cruadapp.model.Skill;
import cruadapp.repository.SkillRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SkillServiceTest extends TestCase {
    @InjectMocks
    GenericService<Skill, Integer> service;

    @Mock
    SkillRepository repository;

    @Before
    public void setUp(){
        service = new GenericService<>(repository);
    }

    @Test
    public void getAllSkillTest(){
        List<Skill> skills = new ArrayList<>(List.of(
                new Skill(1, "Python"),
                new Skill(2,"Java")
        ));

        Mockito.when(repository.getAll()).thenReturn(skills);
        assertEquals(skills,service.getAll());
        Mockito.verify(repository).getAll();
    }

    @Test(expected = Exception.class)
    public void whenSkillAnnotation(){
        Mockito.when(repository.getAll()).thenThrow(IllegalStateException.class);
        repository.getAll();
    }


    @Test
    public void getByIdTest(){
        Skill skill = new Skill(1,"Java");

        Mockito.when(repository.getById(1)).thenReturn(skill);
        assertEquals(skill, service.getById(1));
        Mockito.verify(repository).getById(1);
    }

}

import com.entity.Quest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class QuestTest {
    @Mock
    Quest quest = Quest.getInstance();
    @Test
    public void WhenQuestInitThenQuestionsInit(){
     try (MockedStatic<Quest> utilities =  Mockito.mockStatic(Quest.class)) {
        //добавляем правило
        utilities.when(Quest::getInstance).thenReturn(Quest.class);

        //проверяем, что правило работает
        assertEquals(Quest.class, Quest.getInstance());
    }
     catch (RuntimeException e)
     {
         System.out.println(e.getStackTrace());
     }
    }

    @Test
    public void WhenGetTheFistQuestionAnswerIsCorrect()
    {
       quest.questions.get(0);
       Mockito.verify(quest).questions.get(0);
    }

}

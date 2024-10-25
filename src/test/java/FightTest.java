import com.entity.Monster;
import com.services.Fight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FightTest {
    @Mock
    Monster monst = new Monster(110, 70);

    @Test
    public void WhenMonsterDamageIsMoreThanCharacterHPThenReturn() {

        try (MockedStatic<Fight> fightExecutorTest = Mockito.mockStatic(Fight.class)) {
            //добавляем правило
            fightExecutorTest.when(() -> Fight.fightExecutor(1, 100, monst))
                    .thenReturn(-1);
            //проверяем, что правило работает
            assertEquals(-1, Fight.fightExecutor(1, 100, monst));
        }
    }

   }

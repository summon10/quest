import com.controllers.FightServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.Mockito.*;

public class FightServletTest {


    @Test
    public void WhenCharacterHPLessThenZeroThenRedirectToCorrectPage() throws IOException {
        FightServlet servlet = new FightServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
     try {
        Method method = FightServlet.class.getDeclaredMethod("doPost", HttpServletRequest.class, HttpServletResponse.class);
        method.setAccessible(true);
        method.invoke(servlet,req, resp);

    }
    catch (NoSuchMethodException e)
    {

    } catch (InvocationTargetException | IllegalAccessException e)
        {
        throw new RuntimeException(e);
    }
    verify(resp, times(1)).sendRedirect(any(String.class));


    }
}

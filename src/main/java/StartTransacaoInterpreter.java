import java.util.ArrayList;
import java.util.List;

public class StartTransacaoInterpreter implements LogInterpreter{

    @Override
    public String interpret(String log) {
        String str = ("Iniciar transação " + log.substring(1,3));
        return str;
    }
}

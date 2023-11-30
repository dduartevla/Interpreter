import java.util.ArrayList;
import java.util.List;

public class WriteOperacaoInterpreter implements LogInterpreter{

    @Override
    public String interpret(String log) {
        List<String> operations = new ArrayList<>();
        String[] tokens = log.substring(2, log.length() - 1).split(",");
        String str = ("Alteração de " +tokens[1] + ", de " + tokens[2] + " para " + tokens[3]);
        return str;
    }
}

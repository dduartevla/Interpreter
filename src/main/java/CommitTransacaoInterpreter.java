import java.util.ArrayList;
import java.util.List;

public class CommitTransacaoInterpreter implements LogInterpreter{

    @Override
    public String interpret(String log) {
        String str = ("Commit da transação " + log.substring(1,3));
        return str;
    }
}

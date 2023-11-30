import java.util.ArrayList;
import java.util.List;

public class LogContexto {

    private String log;

    private List<String> operacoesInterpretadas;

    public LogContexto(){
        operacoesInterpretadas = new ArrayList<>();
    }

    public void interpretarLog(){

        LogInterpreter interpreter;

        List<String> lines = breakLogIntoLines(log);

        for (String line : lines) {
            if (line.contains("start")){
                interpreter = new StartTransacaoInterpreter();
            } else if (line.contains("commit")){
                interpreter = new CommitTransacaoInterpreter();
            } else {
                interpreter = new WriteOperacaoInterpreter();
            }
            operacoesInterpretadas.add(interpreter.interpret(line));
        }
    }

    private List<String> breakLogIntoLines(String log) {
        String[] linesArray = log.split("\n");
        return List.of(linesArray);
    }

    public String getOperacoesInterpretadas() {
        String str = "";

        for(int i=0; i<operacoesInterpretadas.size(); i++){
            str = str + operacoesInterpretadas.get(i) + "\n";
        }

        return str;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        if (log.isEmpty()){
            throw  new IllegalArgumentException("Log Vazio");
        }
        this.log = log;
    }
}

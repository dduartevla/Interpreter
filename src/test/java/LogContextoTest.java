import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogContextoTest {

    @Test
    void deveRetornarLogWrite(){
        LogContexto contexto = new LogContexto();
        String log = "<T1,X,1000,950>";
        contexto.setLog(log);
        contexto.interpretarLog();
        assertEquals("Alteração de " + "X" + ", de " + 1000 + " para " + 950+"\n",
                contexto.getOperacoesInterpretadas());
    }

    @Test
    void deveRetornarLogStart(){
        LogContexto contexto = new LogContexto();
        String log = "<T1 start>";
        contexto.setLog(log);
        contexto.interpretarLog();
        assertEquals("Iniciar transação T1"+"\n",
                contexto.getOperacoesInterpretadas());
    }

    @Test
    void deveRetornarLogCommit(){
        LogContexto contexto = new LogContexto();
        String log = "<T1 commit>";
        contexto.setLog(log);
        contexto.interpretarLog();
        assertEquals("Commit da transação T1"+"\n",
                contexto.getOperacoesInterpretadas());
    }

    @Test
    void deveRetornarVariosLogs(){
        LogContexto contexto = new LogContexto();
        String log = "<T1 start>\n<T1,X,1000,950>\n<T1 commit>\n<T2 start>\n<T2,Y,50,100>";
        contexto.setLog(log);
        contexto.interpretarLog();
        assertEquals("Iniciar transação T1"+"\n" +
                        "Alteração de " + "X" + ", de " + 1000 + " para " + 950+"\n" +
                        "Commit da transação T1"+"\n"+
                        "Iniciar transação T2"+"\n" +
                        "Alteração de " + "Y" + ", de " + 50 + " para " + 100+"\n",
                contexto.getOperacoesInterpretadas());
    }

    @Test
    void deveRetornarErroLogvazio(){
        try {
            LogContexto contexto = new LogContexto();
            String log="";
            contexto.setLog(log);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("Log Vazio", e.getMessage());
        }
    }
}
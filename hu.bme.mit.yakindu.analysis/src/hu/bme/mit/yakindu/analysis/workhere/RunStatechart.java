package hu.bme.mit.yakindu.analysis.workhere;
import java.io.IOException;
import hu.bme.mit.yakindu.analysis.TimerService;
import hu.bme.mit.yakindu.analysis.RuntimeService;
import hu.bme.mit.yakindu.analysis.example.ExampleStatemachine;
import hu.bme.mit.yakindu.analysis.example.IExampleStatemachine;
import java.util.Scanner;
public class RunStatechart {
public static void main(String[] args) throws IOException {
ExampleStatemachine s = new ExampleStatemachine();
s.setTimer(new TimerService());
RuntimeService.getInstance().registerStatemachine(s, 200);
s.init();
s.enter();
s.runCycle();
boolean end=false;
while(end==false) {
Scanner in = new Scanner(System.in);
String string = in.nextLine();
if(string.equals("start")) {
s.raiseStart();
s.runCycle();
print(s);
}
if(string.equals("white")) {
s.raiseWhite();
s.runCycle();
print(s);
}
if(string.equals("black")) {
s.raiseBlack();
s.runCycle();
print(s);
}
if(string.equals("exit")) {
System.exit(0);
end=true;
in.close();
}
}
}
public static void print(IExampleStatemachine s) {
System.out.println(" W =" + s.getSCInterface().getWhiteTime()     );
System.out.println(" B =" + s.getSCInterface().getBlackTime()     );

}
}

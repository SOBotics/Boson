package org.sobotics.boson.framework.services.chat.printers;

public abstract class PrinterService <T>{

    public String print(T object){
        return print(object, null);
    }

    public String print(T object, String dashboard) {
        String intro = getGenericIntro();
        return print(object, dashboard, intro);
    }

    String getGenericIntro() {
        return "[Boson](https://git.io/vA9TM)";
    }

    String getFinalPrintString(String dashboard, String intro, String message) {
        String return_string;
        if (dashboard!=null) {
            return_string = "[ " + intro + " | " + dashboard + " ] " + message ;
        }
        else {
            return_string = "[ " + intro +  " ] " + message ;
        }
        return return_string;
    }

    abstract String print(T object, String dashboard, String intro);
}

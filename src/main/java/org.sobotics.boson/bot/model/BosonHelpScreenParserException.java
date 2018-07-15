package org.sobotics.boson.bot.model;

import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;

public class BosonHelpScreenParserException extends ArgumentParserException {

    String message;
    public BosonHelpScreenParserException(ArgumentParser parser, String message) {
        super(parser);
        this.message = message;
    }
    public String getParserMessage(){
        return message;
    }
}
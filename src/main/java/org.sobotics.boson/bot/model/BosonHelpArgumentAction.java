package org.sobotics.boson.bot.model;

import net.sourceforge.argparse4j.inf.Argument;
import net.sourceforge.argparse4j.inf.ArgumentAction;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public class BosonHelpArgumentAction implements ArgumentAction {

    @Override
    public void run(ArgumentParser parser, Argument argument, Map<String, Object> map, String s, Object o) throws ArgumentParserException {
        StringWriter out = new StringWriter();
        PrintWriter writer = new PrintWriter(out);
        parser.printHelp(writer);
        throw new BosonHelpScreenParserException(parser, out.toString());
    }

    @Override
    public void onAttach(Argument argument) {

    }

    @Override
    public boolean consumeArgument() {
        return false;
    }
}
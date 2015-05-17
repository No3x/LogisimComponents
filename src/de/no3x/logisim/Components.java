package de.no3x.logisim;
/**
 * Created by No3x on 17.05.15.
 */

import com.cburch.logisim.tools.AddTool;
import com.cburch.logisim.tools.Library;
import com.cburch.logisim.tools.Tool;

import java.util.Arrays;
import java.util.List;

/**
 * The library of components that the user can access.
 */
public class Components extends Library {
    /**
     * The list of all tools contained in this library. Technically,
     * libraries contain tools, which is a slightly more general concept
     * than components; practically speaking, though, you'll most often want
     * to create AddTools for new components that can be added into the circuit.
     */
    private List tools;

    /**
     * Constructs an instance of this library. This constructor is how
     * Logisim accesses first when it opens the JAR file: It looks for
     * a no-arguments constructor method of the user-designated class.
     */
    public Components() {
        tools = Arrays.asList(new Tool[]{
                new AddTool(new Switch())
        });
    }

    /**
     * Returns the name of the library that the user will see.
     */
    public String getDisplayName() {
        return "Erweiterte Komponenten";
    }

    /**
     * Returns a list of all the tools available in this library.
     */
    public List getTools() {
        return tools;
    }
}
